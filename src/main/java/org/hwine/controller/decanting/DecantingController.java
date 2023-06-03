package org.hwine.controller.decanting;

import java.security.Principal;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.hwine.domain.decanting.AvgVO;
import org.hwine.domain.decanting.FollowVO;
import org.hwine.domain.member.FollowerVO;
import org.hwine.domain.product.DecantingBookVO;
import org.hwine.domain.product.ProductVO;
import org.hwine.domain.product.SimpleWineVO;
import org.hwine.exception.CustomNotFoundException;
import org.hwine.exception.ErrorCode;
import org.hwine.service.decanting.DecantingService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lilittlecat.chatgpt.offical.ChatGPT;

import okhttp3.OkHttpClient;

/**
 * 디켄팅북 관련 컨트롤러
 * 
 * @author 조일우
 * @since 2023.03.09
 * @version 1.0
 * 
 *          <pre>
* 수정일        		수정자       				수정내용
* ----------  --------    ---------------------------
* 2023.03.09  	조일우       		최초 생성
* 2023.03.11	조일우			디켄팅북 작성, 수정 기능 구현
* 2023.03.13	조일우			팔로우 기능 구현
* 2023.03.15	조일우			작성, 수정 기능 보안
* 2023.03.16	조일우			미로그인 접근 기능 구현
* 2023.03.22	조일우			팔로우 리스트 구현
* 2023.03.24	조일우			접근 별 디켄팅북 출력 수정
* 2023.03.27	조일우			무한 스크롤 적용
* 2023.04.06	조일우			챗봇 구현
* 2023.04.07	조일우			한줄평 구현
* 2023.04.09	조일우			디켄팅북 리스트 페이지 분석 페이지로 수정
 * 
 */

@Controller
@RequestMapping("/decanting")
public class DecantingController {

	final private int listNum = 9;

	@Autowired
	private DecantingService service;
	
	//디켄팅북 작성
	@GetMapping("/decantingBook")
	public String decantingBook(Principal principal, Model model,
			@RequestParam(value = "db_id", required = false) String db_id,
			@RequestParam(value = "w_id", required = false) String w_id) {
		System.out.println("w_id = " + w_id + " db_id : " + db_id);
		
		//비정상적인 접근 예외처리
		if(w_id == null && db_id == null) {
			throw new CustomNotFoundException(ErrorCode.NOT_FOUND_PAGE_URL);
		}
		
		//디켄팅북 작성 이력이 있을 시 디켄팅북 접근 시
		if (w_id == null && db_id != null) {
			DecantingBookVO vo = service.getReview(db_id);
			model.addAttribute("wine", vo);
			//로그인 시
			if (principal != null) {
				//작성자 본인 로그인 시
				if (vo.getM_email().equals(principal.getName())) {
					model.addAttribute("writeAble", 1);
				} 
				//작성자 이외 접근 시
				else {
					model.addAttribute("writeAble", 0);
				}
				//비정상적인 접근시 
				if (vo.getM_grade() == 0 && !vo.getM_email().equals(principal.getName())) {
					throw new CustomNotFoundException(ErrorCode.NOT_FOUND_PAGE_URL);
				}
			} 
			//미 로그인 시 
			else {
				model.addAttribute("writeAble", 0);
			}
		} 
		//로그인 시
		else if (principal != null) {
			db_id = service.checkDB(w_id, principal.getName());
			//해당 와인에 리뷰 작성이 이력이 있을 시
			if (null != db_id) {
				DecantingBookVO vo = service.getReview(db_id);
				model.addAttribute("wine", vo);
				if (vo.getM_email().equals(principal.getName())) {
					model.addAttribute("writeAble", 1);
				} else {
					model.addAttribute("writeAble", 0);
				}
				//비정상적인 접근시 
				if (vo.getM_grade() == 0 && !vo.getM_email().equals(principal.getName())) {
					throw new CustomNotFoundException(ErrorCode.NOT_FOUND_PAGE_URL);
				}
			} 
			//아직 해당 와인에대한 디켄팅 북 작성이 없을 시
			else {
				DecantingBookVO vo = service.getWineMin(w_id);
				model.addAttribute("wine", vo);
				System.out.println("w_id = " + w_id + " db_id : " + db_id);
				model.addAttribute("writeAble", 1);
				model.addAttribute("NewDB", 1);
			}
		} else {
			return "/";
		}
		return "/decanting/decantingBook";
	};

	//디켄팅북 작성
	@PostMapping("/write.do")
	@ResponseBody
	public void decantingBookWrite(Principal principal, @RequestParam("content") String content,
			@RequestParam("rating") int rating, @RequestParam("sweetness") int sweetness,
			@RequestParam("tannin") int tannin, @RequestParam("body") int body, @RequestParam("acidity") int acidity,
			@RequestParam("w_id") String w_id, @RequestParam("hide") int hide) {
		System.out.println(content + rating + sweetness + tannin + body + acidity + w_id);
		service.DWrite(principal.getName(), w_id, content, rating, sweetness, tannin, body, acidity, hide);
	};
	
	//팔로우한 H-믈리 리스트 출력
	@GetMapping("/followList")
	public String followList(Model model, Principal principal) {
		final int followNum = 20;
		final int start = 1;

		model.addAttribute("followList", service.getFollowList(principal.getName(), start, start + followNum));
		return "/decanting/followList";
	}

	//팔로우한 H믈리 리스트 무한 스크롤
	@PostMapping("/moreFollow")
	@ResponseBody
	public List<FollowerVO> moreFollow(Model model, Principal principal, @RequestParam("start") int start) {
		final int followNum = 20;
		return service.getFollowList(principal.getName(), start, start + followNum);
	}

	//H-믈리 팔로우
	@PostMapping("/follow")
	@ResponseBody
	public void follow(Principal principal, @RequestParam("follow") int follow,
			@RequestParam(value = "f_id") String f_id) {
		System.out.println(follow + " : " + f_id);
		if (follow < 0) {
			service.followInsert(f_id, principal.getName());
		} else {
			System.out.println(f_id);
			service.follow(follow, f_id);
		}
	}

	//분석페이지 출력
	@GetMapping("/bookList")
	public String getBookList(Principal principal, @RequestParam(value = "db_id", required = false) String db_id,
			Model model, RedirectAttributes rttr) throws Exception {
		List<DecantingBookVO> list = null;

		int reviewNum = 0;
		FollowVO followVO = null;
		List<ProductVO> blList = null;
		List<ProductVO> brList = null;
		AvgVO HAvg = null;
		AvgVO myAvg = null;
		
		//H-믈리 분석페이지 접근시 / 미 로그인시
		if (db_id != null) {
			list = service.getReviewList(db_id, 1, 10,0, null);
			System.out.println(list);
			reviewNum = service.getReviewNum(db_id, 1, 10, 0, null);
			HAvg = service.getHAvg(db_id);
			//H-믈리 와인 가격, 당도, 산도, 탄닌, 바디 평균 출력
			model.addAttribute("HAvg", HAvg);
			//한줄평
			model.addAttribute("HOneLine", service.getHOneLine( db_id));
			//미 로그인 시
			if (principal == null) {
				followVO = service.following(db_id, null);
				//팔로우 여부
				model.addAttribute("followVO", followVO);
				//취향이 맞을 만한 와인 리스트
				List<ProductVO> rList = service.getbrList(db_id, null, (int) Math.round(HAvg.getAcidAvg()),
						(int) Math.round(HAvg.getBodyAvg()), (int) Math.round(HAvg.getSweetAvg()),
						(int) Math.round(HAvg.getTanninAvg()));
				model.addAttribute("rList", rList);
			// 로그인시
			} else{
				//나의 와인 가격, 당도, 산도, 탄닌, 바디 평균 출력
				myAvg = service.getMyAvg(principal.getName());
				//H-믈리와 내가 좋아한 와인 리스트 출력
				blList = service.getblList(db_id, principal.getName());
				//평균 연산 가능시 
				if(myAvg != null) {
				brList = service.getbrList(db_id, principal.getName(),
						(int) Math.round((HAvg.getAcidAvg() + myAvg.getAcidAvg()) / 2),
						(int) Math.round((HAvg.getBodyAvg() + myAvg.getBodyAvg()) / 2),
						(int) Math.round((HAvg.getSweetAvg() + myAvg.getSweetAvg()) / 2),
						(int) Math.round((HAvg.getTanninAvg() + myAvg.getTanninAvg()) / 2));
				}
				model.addAttribute("blList", blList);
				model.addAttribute("brList", brList);
				model.addAttribute("db_id", db_id);
				model.addAttribute("MyAvg", myAvg);
				followVO = service.following(db_id, principal.getName());
				model.addAttribute("followVO", followVO);
				System.out.println(followVO);
				model.addAttribute("oneLine", service.getOneLine( principal.getName()));
				model.addAttribute("HOneLine", service.getHOneLine( db_id));
			}
		} 
		//로그인 시 
		else if (principal != null) {
			//나의 와인 가격, 당도, 산도, 탄닌, 바디 평균 출력
			myAvg = service.getMyAvg(principal.getName());
			model.addAttribute("MyAvg", myAvg);
			
			//H-믈리가 취향에 맞을만한 와인 출력
			List<ProductVO> rList = service.getbrList(null, principal.getName(), (int) Math.round(myAvg.getAcidAvg()),
					(int) Math.round(myAvg.getBodyAvg()), (int) Math.round(myAvg.getSweetAvg()),
					(int) Math.round(myAvg.getTanninAvg()));
			model.addAttribute("rList", rList);
			System.out.println(myAvg);
			list = service.getMyReviewList(principal.getName(), 1, 10, 0, null);
			reviewNum = service.getMyReviewNum(principal.getName(), 1, 10, 0, null);
			model.addAttribute("myReview", 1);
			DecantingBookVO vo = service.getMyReview(principal.getName());
			
			if(vo != null) { //작성한 적이 있을 시 
				model.addAttribute("name", vo.getM_nickname());
				followVO = service.following(null, principal.getName());
				model.addAttribute("followVO", followVO);
				System.out.println(followVO);
				model.addAttribute("oneLine", service.getOneLine( principal.getName()));
			}else {
				rttr.addFlashAttribute("never_written_dbook", true);
				return "redirect:/";
			}
			
		} 
		//미 로그인 시 로그인 페이지로
		else {
			return "/member/login";

		}
		if (!list.isEmpty()) {
			model.addAttribute("reviewNum", reviewNum);
		}

		model.addAttribute("bookList", list);
		return "/decanting/bookList";
	}

	//디켄팅북 리스트 무한 스크롤
	@GetMapping("/newBookList")
	@ResponseBody
	public List<DecantingBookVO> getBookList(Principal principal,
			@RequestParam(value = "db_id", required = false) String db_id, @RequestParam(value = "start") int start,
			@RequestParam(value = "ctgr", required = false) String ctgr,
			@RequestParam(value = "sort", required = false) int sort, Model model) {
		List<DecantingBookVO> list = null;
		DecantingBookVO vo = service.getReview(db_id);
		if (ctgr.equals("-")) {
			ctgr = null;
		}
		if (principal != null && principal.getName().equals(vo.getM_email())) {
			list = service.getMyReviewList(principal.getName(), start, start + listNum, sort, ctgr);
			//리뷰 갯수 첫번쨰 디켄팅북VO에 담기
			if (!list.isEmpty()) {
				list.get(0).setCnt(service.getMyReviewNum(principal.getName(), start, start + listNum, sort, ctgr));
			}
		} else {
			list = service.getReviewList(db_id, start, start + listNum, sort, ctgr);
			//리뷰 갯수 첫번쨰 디켄팅북VO에 담기
			if (!list.isEmpty()) {
				list.get(0).setCnt(service.getReviewNum(db_id, start, start + listNum, sort, ctgr));
			}
		}
		;
		//보인 이슈로 VO에 저장된 아이디 삭제
		for (DecantingBookVO votmp : list) {
			votmp.setM_email("");
		}
		return list;
	}

	//챗봇 와인 존재하는지 확인
	@GetMapping("/wineRec")
	@ResponseBody
	public String winRecommand(@RequestParam(value = "prompt") String prompt) {
		OkHttpClient client = new OkHttpClient.Builder().readTimeout(120, TimeUnit.SECONDS)
				.writeTimeout(120, TimeUnit.SECONDS).build();
		ChatGPT chatGPT = new ChatGPT("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", client);
		String ans = "0";
		//GPT API 호출
		ans = chatGPT.ask(prompt +" 와인이 존재해? YES or NO로 대답해줘");
		System.out.println(ans);
		if(ans.contains("YES")) {
			ans = "1";
		}
		return ans;
	}

	//챗봇 질문에 맞는 와인 추천
	@GetMapping("/wineRec2")
	@ResponseBody
	public List<SimpleWineVO> winRecommand2(@RequestParam(value = "prompt") String prompt) {
		List<SimpleWineVO> list = new ArrayList<SimpleWineVO>();
		
		OkHttpClient client = new OkHttpClient.Builder().readTimeout(120, TimeUnit.SECONDS)
				.writeTimeout(120, TimeUnit.SECONDS).build();
	      long beforeTime = System.currentTimeMillis();
		ChatGPT chatGPT = new ChatGPT("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", client);
		//GPT API 호출
		String ans =  chatGPT.ask(prompt+" 에 대해 50자 내로 설명해주고 json format [{\"name\" : name, \"desc\" : desc}] 으로 와인이름은 영어로 설명은 한국어로 와인 3개 추천해줘");
	    System.out.println(ans);
	      long afterTime = System.currentTimeMillis(); 
	      long secDiffTime = (afterTime - beforeTime)/1000;
	      System.out.println("시간차이(m) : "+secDiffTime);
	      beforeTime = System.currentTimeMillis();
	    int jsonIndex = ans.indexOf("[{");
	    if( jsonIndex < 0) {
	    	return list;
	    }
	    String json = ans.substring(jsonIndex);
	    ans = ans.substring(0,jsonIndex - 1);
		JSONArray array = new JSONArray(json);  
	      //GPT 호출 결과 데이터베이스에서 검색
	      for(int i = 0; i < array.length(); i++) {
	    	  JSONObject object = array.getJSONObject(i);  
	    	  String tmp = deAccent(object.getString("name")).replaceAll("[0-9]", "").replace("-", "").replace("'", "");
	    	  if(tmp.substring(tmp.length()).equals(" ")) {
	    		  tmp = tmp.substring(0,tmp.length() -1);
	    	  }
	    	  SimpleWineVO vo = service.isWineThere(tmp.replace(" ", "%").replace(",", ""));
	    	  if(vo != null) {
			      vo.setDesc(object.getString("desc"));  
			      list.add(vo);  
	    	  }
	      }
	      if(!list.isEmpty()) {
	    	  list.get(0).setMainDesc(ans);
	      }
	      afterTime = System.currentTimeMillis(); 
	      secDiffTime = (afterTime - beforeTime)/1000;
	      System.out.println("시간차이(m) : "+secDiffTime);
		return list;
	}
	
	//기념일별 와인 출력
	@GetMapping("/anvWine")
	@ResponseBody
	public List<SimpleWineVO> getAnyversary ( ){
		List<SimpleWineVO> list = new ArrayList<SimpleWineVO>();
		list = service.getAnvWine();
		return list;
	}
	
	//엑센트 문자 일반 영문으로 변경 메소드
    public String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
	
	
}
