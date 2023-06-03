package org.hwine.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
* 커스텀 예외
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
@AllArgsConstructor
@Getter
public class CustomNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -7015613306254220553L;
	
	private final ErrorCode errorCode;
}
