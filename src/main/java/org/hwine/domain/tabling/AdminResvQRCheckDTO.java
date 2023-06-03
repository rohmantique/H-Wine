package org.hwine.domain.tabling;

import org.hwine.domain.product.chartVO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AdminResvQRCheckDTO {

	private String rid;
	private int rstatus;
	private String visitDateTime;
	private int headcount;
	private String table;
	private String memberMsg;
	private String adminNote;
	
	private String member;
	private String scode;
	private String storename;
	
	private String confirm;

	public AdminResvQRCheckDTO(AdminResvQRCheckVO vo) {
		this.rid = vo.getR_id();
		this.rstatus = vo.getR_status();
		this.storename = vo.getS_name();
		this.visitDateTime = TablingUtils.processReservationDateTime(vo.getR_date(), vo.getR_time()); //TODO
		this.headcount = vo.getR_head_count();
		this.table = vo.getSt_id();
		this.member = markingMemberName(vo.getM_name());
		this.memberMsg = vo.getR_msg();
		this.adminNote = vo.getR_admin_note();
		this.scode = vo.getS_code();
	}
	
	private String markingMemberName(String name) {
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for(char c : name.toCharArray()) {
			if(idx % 2 == 1) {
				sb.append('*');
			}else {
				sb.append(c);
			}
		}
		
		System.out.println("멤버 마스킹:" + sb.toString());
		
		return sb.toString();
	}
}
