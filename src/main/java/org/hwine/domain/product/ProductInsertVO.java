package org.hwine.domain.product;

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
@Getter
@Setter
public class ProductInsertVO {
	
	private String w_id;
	private String w_name_kor;
	private String w_name ;
	private String w_img;
	private int w_price;
	
	private String w_ferment;
	private String w_temperature;
	private int w_volume ;
	private String w_type;
	
	private String wv_variety;
	private String wv_variety_kor; 
	private String wr_nation;
	private String wr_nation_kor;
	private String wr_area;
	private String wr_area_kor;
	
	private String wm_maker_kor;
	private String wm_maker;
	
	private String w_alcohol;
	private int w_sweetness;
	private int w_acidity;
	private int w_body;
	private int w_tannin;
	
	private String wa_name;
	private String wa_img_url;
	private String[] was_name;
	private String wf_name;
	private String wf_img_url;
	private String[] wfs_name;
	
	private String s_code;
	private int sws_stock; //재고
	private String s_name;
	private int sws_order; //발주

}
