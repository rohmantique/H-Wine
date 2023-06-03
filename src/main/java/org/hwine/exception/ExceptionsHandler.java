package org.hwine.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

/**
* 예외 ControllAdvice
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
@ControllerAdvice
@Log4j
public class ExceptionsHandler{

	@ExceptionHandler(TablingException.class)
	public @ResponseBody ResponseEntity<ErrorResponse> handleTablingException(TablingException e){
		log.error("테이블링 오류: " + e.getErrorCode().getMessage());
		return ErrorResponse.toResponseEntity(e.getErrorCode());
	}
	
	@ExceptionHandler(CustomNotFoundException.class)
	public String handlerCustomNotFoundException(CustomNotFoundException e) {
		log.error("custom not_found_ex: " + e.getErrorCode().getMessage());
		return "/exception/ex404";
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handlerMissingServletRequestParameterException(MissingServletRequestParameterException e) {
		log.error("잘못된 파라미터 : " + e.getParameterName());
		return "/exception/ex404";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handlerNotFoundException(NoHandlerFoundException e) {
		log.error("not_found_ex: " + e.getMessage());
		return "/exception/ex404";
	}
	
	@ExceptionHandler(AsyncRequestTimeoutException.class)
	public void handleAsync(AsyncRequestTimeoutException e) {
		log.error("여기[" + e);
		
	}

}

