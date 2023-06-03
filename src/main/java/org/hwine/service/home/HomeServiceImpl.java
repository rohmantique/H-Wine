package org.hwine.service.home;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hwine.domain.member.MemberVO;
import org.hwine.domain.product.MainProductVO;
import org.hwine.domain.product.MainWineListFoodDTO;
import org.hwine.domain.product.ProductVO;
import org.hwine.mapper.home.HomeMapper;
import org.hwine.mapper.member.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 홈 관련 Service
 * 
 * @author : 김주현
 * @since 2023.04.14
 * @version 1.0
 * 
 *          <pre>
* 수정일       수정자       수정내용
* ----------  --------    ---------------------------
* 2023.04.14  김주현       	메인 로직 구현
 *          </pre>
 * 
 */
@Service
@RequiredArgsConstructor
@Log4j
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HomeMapper homeMapper;
	private final MemberMapper memberMapper;

	@Override
	public List<ProductVO> bestProduct6() {
		return homeMapper.bestProduct6();
	}

	@Override
	public List<ProductVO> newProduct6() {
		return homeMapper.newProduct6();
	}
	
	@Override
	public MainWineListFoodDTO getWineListWithFood(String wfood){
		return new MainWineListFoodDTO(wfood, homeMapper.selectMainFoodWineList(wfood));
	}

	@Override
	public Map<String, List<MainProductVO>> mainProduct() {
		
		log.info("메인 페이지 판매량 10개, 일주일동안 새롭게 등록된 10개 상품 조회");
		Map<String, List<MainProductVO>> map = new HashMap<>();
		map.put("best", homeMapper.mainBestProduct());
		map.put("new", homeMapper.mainNewProduct());
		map.put("nonLogin", homeMapper.nonLoginProduct());
		log.info(map);
		return map;
	}
	
	@Override
	public Map<String, List<MainProductVO>> getWineListBasedMemeberBirthAndGender(String memail) {

		MemberVO vo = memberMapper.findMember(memail);
		log.info("성별, 연령에 따른 와인 리스트 추천 시작" + vo.getMBirthDate() + ", " + vo.getMGender());
		log.info(homeMapper.wineListBasedMemeberBirthAndGender(vo.getMBirthDate(), vo.getMGender()));
		Map<String, List<MainProductVO>> map = new HashMap<>();
		map.put("birthAndGender", homeMapper.wineListBasedMemeberBirthAndGender(vo.getMBirthDate(), vo.getMGender()));
		log.info(map);
		return map;
	}
	
}
