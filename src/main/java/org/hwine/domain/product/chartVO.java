package org.hwine.domain.product;

import lombok.Data;
/**
* 상품 및 판매 동향 분석 관련 DTO
* @author : 노희진
* @since 2023.03.30
* @version 1.0 
* 
* 수정일       수정자       수정내용
* ----------  --------    ---------------------------
* 2023.04.07  노희진       	최초 생성
* 
*/
@Data
public class chartVO {
	private String x;
	private String y;
}
