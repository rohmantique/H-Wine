package org.hwine.service.decanting;

import java.security.Principal;
import java.util.List;

import org.hwine.domain.decanting.AvgVO;
import org.hwine.domain.decanting.FollowVO;
import org.hwine.domain.member.FollowerVO;
import org.hwine.domain.product.DecantingBookVO;
import org.hwine.domain.product.ProductVO;
import org.hwine.domain.product.SimpleWineVO;
import org.hwine.exception.CustomNotFoundException;
import org.hwine.exception.ErrorCode;
import org.hwine.mapper.decanting.DecantingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 디켄팅북 관련 서비스 임플리먼트
* @author 조일우
* @since 2023.03.09
* @version 1.0 
* 
* <pre>
* 수정일        		수정자       				수정내용
* ----------  --------    ---------------------------
* 2023.03.09  	조일우       		최초 생성
* 2023.03.11	조일우			작성, 수정 기능 구현
* 2023.03.13	조일우			팔로우 기능 구현
* 2023.03.15	조일우			작성, 수정 기능 보안
* 2023.03.16	조일우			미로그인 접근 기능 구현
* 2023.03.24	조일우			접근 별 디켄팅북 출력 수정
* 2023.03.27	조일우			무한 스크롤 적용
* 2023.04.06	조일우			챗봇 구현
* 2023.04.07	조일우			한줄평 구현
* 2023.04.09	조일우			디켄팅북 리스트 페이지 분석 페이지로 수정
* </pre>
* 
*/

@Service
public class DecantingServiceImpl implements DecantingService{
	@Autowired
	private DecantingMapper mapper;
	
	//디켄팅 북 입력
	@Override
	public void DWrite(String m_email, String w_id, String content, int rating, int sweetness, int tannin, int body,
			int acidity, int hide) {
		mapper.Dwrite(m_email, w_id, content, rating, sweetness, tannin, body, acidity, hide);
	}

	//디켄팅 북 출력
	@Override
	public DecantingBookVO getReview(String db_id) {
		DecantingBookVO vo = mapper.getReview(db_id);
		
		if(vo == null)
			throw new CustomNotFoundException(ErrorCode.NOT_FOUND_DECATING_BOOK);
		return  vo;
	}

	//팔로우 리스트 출력
	@Override
	public List<FollowerVO> getFollowList(String m_email, int start, int end) {
		return mapper.getFollowList(m_email, start, end);
	}

	//H-믈리 팔로우 입력
	@Override
	public void follow(int follow, String f_id) {
		if(follow > 0) {
			mapper.unfollow( f_id);
		}
		else {
			mapper.follow(f_id);
		}
	}

	//수정 가능 여부 출력
	@Override
	public int getAble(String r_id, String m_email) {
		return mapper.getAble(r_id, m_email);
	}

	//회원 등급 출력
	@Override
	public int getGrade(String m_email) {
		return mapper.getGrade(m_email);
	}

	//와인 정보 출력
	@Override
	public DecantingBookVO getWine(String r_id) {
		return mapper.getWine(r_id);
	}

	//첫 팔로우 시 팔로우 정보 입력 
	@Override
	public void followInsert(String db_id,String m_email) {
			mapper.followInsert(m_email, db_id);
	}

	//H-믈리의 디켄팅북 리스트 출력
	@Override
	public List<DecantingBookVO> getReviewList(String db_id, int start, int end, int sort, String type) {
			
		return mapper.getReviewList(db_id, start, end, sort, type);
	}

	//내 디켄팅북 리스트 출력
	@Override
	public List<DecantingBookVO> getMyReviewList(String name, int start, int end, int sort, String type) {

		return mapper.getMyReviewList(name, start, end, sort, type);
	}

	//팔로우 기록 있을시 팔로우/언팔로우 입력
	@Override
	public FollowVO following(String db_id, String name) {
		return mapper.following(db_id, name);
	}

	//H-믈리 디켄팅북 갯수 출력
	@Override
	public int getReviewNum(String db_id, int start, int end, int sort, String type) {
		return mapper.getReviewNum(db_id, start,  end,  sort,  type);
	}

	//내 디켄팅북 갯수 출력
	@Override
	public int getMyReviewNum(String name, int start, int end, int sort, String type) {
		return mapper.getMyReviewNum(name, start,  end,  sort,  type);
	}

	//와인 최소정보 출력
	@Override
	public DecantingBookVO getWineMin(String w_id) {
		
		return mapper.getWineMin(w_id);
	}

	//디켄팅북 작성여부 출력
	@Override
	public String checkDB(String w_id, String name) {
		return mapper.checkDB(w_id, name);
	}

	//내 디켄팅북 출력
	@Override
	public DecantingBookVO getMyReview(String name) {
		return mapper.getMyReview(name);
	}

	//H-믈리 와인 취향 평균 출력
	@Override
	public AvgVO getHAvg(String db_id) {
		return mapper.getHAvg(db_id);
	}
	
	//내 와인 취향 평균 출력
	@Override
	public AvgVO getMyAvg(String name) {
		return mapper.getMyAvg(name);
	}
	
	//둘다 좋아한 와인 리스트 출력
	@Override
	public List<ProductVO> getblList(String db_id, String name) {
		return mapper.getblList(db_id, name);
	}

	//둘다 좋아할 만한 or H-믈리 또는 나의 좋아할 만한 와인 리스트 출력 
	@Override
	public List<ProductVO> getbrList(String db_id, String name, int acid, int body, int sweet, int tannin) {
		return mapper.getbrList(db_id, name, acid,body,sweet,tannin);
	}

	//해당 이름의 와인이 존재하는지 확인
	@Override
	public SimpleWineVO isWineThere(String name) {
		return mapper.isWineThere(name);
	}

	//기념일별 와인 리스트 출력 (현재 날짜의 1달 내로)
	@Override
	public List<SimpleWineVO> getAnvWine() {
		List<SimpleWineVO> list = mapper.getAnvWine();
		for(int i = 0; i < list.size(); i++) {
			list.get(i).setA_date(list.get(i).getA_date().replace("-", "월 ").concat("일"));  
		}
		return list;
	}
	
	//내 한줄평 출력
	@Override
	public String getOneLine(String name) {
		return mapper.getOneLine(name);
	}
	
	//H-믈리 한줄평 출력
	@Override
	public String getHOneLine(String db_id) {
		return mapper.getHOneLine(db_id);
	}
	
	
}
