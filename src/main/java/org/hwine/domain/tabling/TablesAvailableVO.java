package org.hwine.domain.tabling;

import java.time.LocalDate;

import lombok.Getter;
import lombok.ToString;

/**
 * 테이블별 가능한지 정보를 가진 VO
 * @author : 김주현
 */

@Getter
@ToString
public class TablesAvailableVO {

	private String tableId;
	private boolean available; 
}
