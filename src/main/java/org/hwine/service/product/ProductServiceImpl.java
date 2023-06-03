package org.hwine.service.product;

import java.util.List;

import org.hwine.domain.product.DecantingBookVO;
import org.hwine.domain.product.ProductVO;
import org.hwine.domain.product.filteredProductVO;
import org.hwine.mapper.product.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

/**
 * 상품 관련 Service
 * 
 * @author : 노희진
 * @since 2023.03.06
 * @version 1.0
 * 
 *          수정일     수정자   수정내용 
 *          ---------- -------- ---------------------------
 *          2023.03.06 노희진   최초 생성 
 *          2023.03.08 노희진   디캔팅 북 관련 로직 추가 
 *          2023.03.13 노희진   정렬 로직 추가 
 *          2023.03.14 노희진   무한 스크롤 로직 추가 
 *          2023.03.16 노희진   필터링된 상품 목록, 유사 상품 추천 로직 추가
 *          2023.03.21 노희진   필터값 중복 선택 로직 추가
 *          2023.03.28 노희진   무한 스크롤, 정렬, 필터 로직 오류 수정
 */

@Service
@Log4j
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper mapper;

	@Override
	public ProductVO selectProductItem(String w_id) {
		return mapper.selectProductItem(w_id);
	}

	@Override
	public List<ProductVO> productStockInfo(String w_id) {
		return mapper.productStockInfo(w_id);
	}
	//미로그인시 디켄팅북 리스트
	@Override
	public List<DecantingBookVO> productDecantingBook(String w_id, int start, int end) {
		return mapper.productDecantingBook(w_id, start, end);
	}
	//디켄팅북 숫자 카운트
	@Override
	public int decantingBookCnt(String w_id, String name) {
		return mapper.decantingBookCnt(w_id, name);
	}
	
	//와인 리스트
	@Override
	public List<ProductVO> productList(String sort, int startIdx, int endIdx) {
		log.info("상품 목록 (정렬 + 무한 스크롤) " + startIdx + "부터 "+ endIdx);
		return mapper.productList(sort, startIdx, endIdx);
	}
	
	//와인 리스트 음식
	@Override
	public List<ProductVO> getProductListByFood(String sort, int startIdx, int endIdx, String wfood) {
		log.info("상품 목록 (정렬 + 무한 스크롤 + 음식) " + startIdx + "부터 "+ endIdx);
		return mapper.productListByFood(sort, startIdx, endIdx, wfood);
	}

	//유사 와인 추천 리스트
	@Override
	public List<ProductVO> relatedProductList(String w_id) {
		log.info("유사 상품 목록 " + w_id);
		return mapper.relatedProductList(w_id);
	}
	//로그인시 디켄팅북 리스트
	@Override
	public List<DecantingBookVO> productDecantingBookLogin(String w_id, String name, int start, int end) {
		return mapper.productDecantingBookLogin(w_id, name, start, end);
	}

	//필터링 리스트
	@Override
	public List<ProductVO> combinedProductList(filteredProductVO filtered, String sort, int startIdx, int endIdx) {
		return mapper.combinedProductList(filtered);
	}

	//필터링 상품 총개수
	@Override
	public int filteredCnt(filteredProductVO filtered) {
		return mapper.filteredCnt(filtered);
	}

}
