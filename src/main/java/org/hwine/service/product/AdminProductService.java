package org.hwine.service.product;

import java.util.List;

import org.hwine.domain.product.AdminProductListVO;
import org.hwine.domain.product.ProductInsertVO;
import org.hwine.domain.product.ProductVO;
import org.hwine.domain.product.chartVO;
import org.springframework.security.core.Authentication;

/**
 * 상품 관리자 Service
 * 
 * @author : 노희진
 * @since 2023.03.30
 * @version 1.0
 *          수정일 		수정자 		수정내용 
 *          ---------- -------- ---------------------------
 *          2023.03.30 노희진   최초 생성 
 *          2023.03.31 노희진   상품 등록 로직 추가 
 *          2023.04.03 노희진   상품 등록 로직 수정, 상품 수정 로직 추가
 *          2023.04.05 노희진	상품 삭제, 상품 수정 로직 수정
 *          2023.04.07 노희진 	상품 판매 동향 분석 (성별, 연령, 기간별, 카테고리별 판매 동향 분석)
 */

public interface AdminProductService {


	// 상품 등록
	public void registerProduct(ProductInsertVO productInsertVO);

	// 상품 조회 (전체/서울/대구)
	public List<AdminProductListVO> adminList(String s_code);

	// 상품 상세
	public ProductVO adminProductItem(ProductInsertVO productInsertVO);

	// 상품 가격 변경
	public void updateWinePriceById(ProductInsertVO productInsertVO);

	// 재고량 변경
	public void updateWineStocks(ProductInsertVO productInsertVO);
	
	// 발주량 변경
	public void updateWineOrderStocks(ProductInsertVO productInsertVO);

	// 상품 삭제
	public void deleteWineById(String w_id);

	public List<ProductVO> getReqOrdList(Authentication auth);

	public List<chartVO> getSalesChart(int type, String w_id, int sumCount, Authentication auth);

	public List<chartVO> getCtgrChart(int type, int sumCount, Authentication auth);

	public List<chartVO> getMemberChart(int type, int sumCount, int genderAge, String w_id, Authentication auth);

	public int getTodaySales();

	public int getTodayPickup();

	public int getTodaySignup();

	public List<ProductVO> getReqPro(int scode);
}
