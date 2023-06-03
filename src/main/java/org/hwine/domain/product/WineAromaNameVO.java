package org.hwine.domain.product;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
* 상품 백오피스 관련 DTO
* @author : 노희진
* @since 2023.03.04
* @version 1.0 
* 
* 수정일       수정자       수정내용
* ----------  --------    ---------------------------
* 2023.03.04  노희진       	최초 생성
* 
*/
@Data
@Getter
@Setter
public class WineAromaNameVO {

	private String wa_name;
	private String was_name;
	private String wa_img_url;

	//음식 이름
	private List<WineFoodNameVO> foodNameList;
}
