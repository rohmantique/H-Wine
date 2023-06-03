package org.hwine.mapper.home;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hwine.domain.product.MainWineFoodVO;
import org.hwine.domain.member.MemberAgeAndBirthVO;
import org.hwine.domain.product.MainProductVO;
import org.hwine.domain.product.ProductVO;

/**
 * 메인 관련 Mapper
 * 
 * @author : 김주현
 * @since 2023.04.14
 * @version 1.0
 * 
 *          <pre>
* 수정일       수정자       수정내용
* ----------  --------    ---------------------------
* 2023.04.14  김주현       	메인 개인화 마케팅 로직 구현
 *          </pre>
 * 
 */
@Mapper
public interface HomeMapper {
	
	//베스트 와인 6개 출력
	public List<ProductVO> bestProduct6();
	
	//신상 와인 6개 출력
	public List<ProductVO> newProduct6();
	
	//음식과 함께하는 와인리스트
	List<MainWineFoodVO> selectMainFoodWineList(String wfood);

	List<MainProductVO> mainBestProduct();
	
	List<MainProductVO> mainNewProduct();
	
	//연령, 성별에 따른 와인리스트
	List<MainProductVO> wineListBasedMemeberBirthAndGender(@Param("birthdate") LocalDate birthdate, @Param("gender") int gender);
	MemberAgeAndBirthVO newbyOrNoPurchaseMember(String memail);
	
	List<MainProductVO> nonLoginProduct();
}
