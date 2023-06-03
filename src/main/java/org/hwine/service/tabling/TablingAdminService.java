package org.hwine.service.tabling;

import java.util.List;

import org.hwine.domain.tabling.AdminReservationDTO;
import org.hwine.domain.tabling.AdminResvQRCheckDTO;
import org.hwine.domain.tabling.AdminResvUpdateForm;
import org.hwine.domain.tabling.AdminTablingMainDTO;

/**
 * 관리자 테이블링 관련 Service
 * 
 * @author : 김주현
 * @since 2023.04.06
 * @version 1.0
 * 
 *          <pre>
* 수정일       수정자       수정내용
* ----------  --------    ---------------------------
* 2023.04.06  김주현       	관리자 서비스 로직 구현 완료
 *          </pre>
 * 
 */
public interface TablingAdminService {
	
	AdminTablingMainDTO getAllMainInfo(String adminId);
	AdminTablingMainDTO getAllMainInfoByTotalAdmin(String scode);

	List<AdminReservationDTO> getReservationList(String adminId);
	List<AdminReservationDTO> getReservationListByTotalAdmin(String scode);
	
	int getTodayReservationCnt(String adminId);
	
	AdminReservationDTO getResvDetail(String rid);
	
	int modifyReservation(AdminResvUpdateForm form);
	
	AdminResvQRCheckDTO findQRInfo(String rid);
	
	void confirmResv(String loginUserId, AdminResvQRCheckDTO dto);
	
}
