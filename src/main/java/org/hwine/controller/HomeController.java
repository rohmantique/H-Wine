package org.hwine.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.hwine.domain.decanting.AvgVO;
import org.hwine.domain.member.HeaderTopMemberInfosDTO;
import org.hwine.domain.product.MainProductVO;
import org.hwine.domain.product.MainWineListFoodDTO;
import org.hwine.service.decanting.DecantingService;
import org.hwine.service.home.HomeService;
import org.hwine.service.member.MemberService;
import org.hwine.service.product.AdminProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
* 메인페이지 관련 Controller
* @author : 김주현, 차민수
* @since 2023.03.06
* @version 1.0 
* 
* <pre>
* 수정일       수정자       수정내용
* ----------  --------    ---------------------------
* 2023.04.05  김주현      	최초 생성(음식 별 와인 추천리스트 로직)
* 2023.04.05  김주현      	디캔팅 북 작성 없을 시 연령별, 성별 추천 로직 추가
* 2023.04.08  차민수		신상품, 판매량 순 추천 로직 추가
* </pre>
* 
*/

@Controller
@RequiredArgsConstructor
@Log4j
public class HomeController {

	private final HomeService homeService;
	private final MemberService memberService;
	private final DecantingService decantingService;
	private final AdminProductService productService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model, Principal principal) {
		log.info("메인 (신상품, 베스트상품 6개씩)" + principal);
		
		if (principal != null) {
			
			AvgVO myAvg = null;
			myAvg = decantingService.getMyAvg(principal.getName());
			log.info(myAvg);
			int acid = (int) Math.round(myAvg.getAcidAvg());
			int body = (int) Math.round(myAvg.getBodyAvg());
			int sweet = (int) Math.round(myAvg.getSweetAvg());
			int tannin = (int) Math.round(myAvg.getTanninAvg());
			log.info(acid + "" + body + sweet+ tannin);
			if (acid != 0 || body != 0 || sweet != 0 || tannin != 0) { // 평점이 0 이 아님 -> 디캔팅 북 작성 내용 존재 -> 취향 뿌림
				model.addAttribute("recProList", decantingService.getbrList(null, principal.getName(), acid, body, sweet, tannin));
			}
			else { // 평점이 0 -> 디캔팅 북 작성 내용 없음 -> 연령별, 나이별
				model.addAttribute("birthAndGender", homeService.getWineListBasedMemeberBirthAndGender(principal.getName())); //얘가 널인지 확인~
			}
		}
		model.addAttribute("mainProduct", homeService.mainProduct());
		return "home";
	}

	@RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	public String adminHome(Authentication authentication, Model model) {
		// log.info("관리자 페이지 진입 -> " + authentication.getName());
		model.addAttribute("admin", memberService.getAdminInfo(authentication.getName()));
		model.addAttribute("reqOrdList", productService.getReqOrdList(authentication));
		model.addAttribute("salesChart", productService.getSalesChart(0, null, 0, authentication));
		model.addAttribute("ctgrChart", productService.getCtgrChart(0, 0, authentication));
		model.addAttribute("genderChart", productService.getMemberChart(0, 0, 0, null,authentication));
		model.addAttribute("ageChart", productService.getMemberChart(0, 0, 1, null, authentication));
		model.addAttribute("genderAgeChart", productService.getMemberChart(0, 0, 2, null, authentication));

		model.addAttribute("todaySales", productService.getTodaySales());
		model.addAttribute("todayPickup", productService.getTodayPickup());
		model.addAttribute("todaySignup", productService.getTodaySignup());
		
		return "/admin/index";
	}

	// 세션 업데이트
	@GetMapping("/updateHeader")
	public ResponseEntity<HeaderTopMemberInfosDTO> updateSessionHeaderInfo(Authentication authentication) {

		if (authentication == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(memberService.getTopMemberInfos(authentication.getName()), HttpStatus.OK);
		}
	}
	
	@GetMapping("/getWineFoodList/{wfood}")
	public @ResponseBody ResponseEntity<MainWineListFoodDTO> getWineFoodList(@PathVariable String wfood) {
		log.info("음식: " + wfood);
		return new ResponseEntity<>(homeService.getWineListWithFood(wfood), HttpStatus.OK);
	}
	
	
}