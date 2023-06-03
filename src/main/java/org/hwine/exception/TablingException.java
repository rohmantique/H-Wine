package org.hwine.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
* 테이블링 예외
* @author : 김주현
* @since 2023.04.14
* @version 1.0 
* 
* <pre>
* 수정일       수정자       수정내용
* ----------  --------    ---------------------------
* 2023.04.14  김주현       	최초 생성

* </pre>
* 
*/
@Getter
@AllArgsConstructor
public class TablingException extends RuntimeException{

	private static final long serialVersionUID = 1101959628152045980L;
	
	private final ErrorCode errorCode;

}
