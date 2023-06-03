package org.hwine.domain.product;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
* 상품 백오피스 관련 DTO
* @author : 노희진
* @since 2023.03.30
* @version 1.0 
* 
* 수정일       수정자       수정내용
* ----------  --------    ---------------------------
* 2023.03.30  노희진       	최초 생성
* 
*/
@Data
@Setter
@Getter
public class AdminProductListVO {

	private String w_id;
	private String w_name_kor;
	private int w_price;
	private LocalDate w_register_date;
	private LocalDate w_update_date;
	private int total_wine_sales;
	private int sws_stock;
}
