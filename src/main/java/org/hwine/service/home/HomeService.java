package org.hwine.service.home;

import java.util.List;
import java.util.Map;

import org.hwine.domain.product.MainProductVO;
import org.hwine.domain.product.MainWineListFoodDTO;
import org.hwine.domain.product.ProductVO;

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
public interface HomeService {

	// 베스트 와인 6개 출력
	public List<ProductVO> bestProduct6();

	// 신상 와인 6개 출력
	public List<ProductVO> newProduct6();
	
	//음식에 따른 와인
	MainWineListFoodDTO getWineListWithFood(String wfood);
	
	Map<String, List<MainProductVO>> mainProduct();
	
	Map<String, List<MainProductVO>> getWineListBasedMemeberBirthAndGender(String memail);

}
