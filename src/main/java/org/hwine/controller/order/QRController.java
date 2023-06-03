package org.hwine.controller.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* QR 코드 관련 Controller
* @author : 차민수
* @since 2023.03.06
* @version 1.0 
* 
* <pre>
* 수정일       수정자       수정내용
* ----------  --------    ---------------------------
* 2023.03.06  차민수      	최초 생성
* 2023.03.08  차민수		QR 코드 생성 로직 추가
* </pre>
* 
*/

@Controller
@RequestMapping("/qrcode")
public class QRController {

	@GetMapping("/load")
	public String qrcodeLoad() {
		return "/admin/websocket/qrcodeRead";
	}
	
	@GetMapping("/loadTest")
	public String qrcodeLoadTest() {
		return "/admin/websocket/qrCodeReadTest";
	}
}
