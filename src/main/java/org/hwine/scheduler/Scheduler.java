package org.hwine.scheduler;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hwine.domain.decanting.AvgVO;
import org.hwine.domain.member.MemberVO;
import org.hwine.mapper.decanting.DecantingMapper;
import org.hwine.mapper.tabling.TablingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lilittlecat.chatgpt.offical.ChatGPT;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import okhttp3.OkHttpClient;

@Component
@Log4j
public class Scheduler {
	/*
	 * // OrderMapper 의존성 주입
	 * 
	 * @Setter(onMethod_ = @Autowired) private TablingMapper mapper;
	 * 
	 * @Autowired private DecantingMapper Dmapper;
	 * 
	 * private OkHttpClient client = new OkHttpClient.Builder().readTimeout(120,
	 * TimeUnit.SECONDS) .writeTimeout(120, TimeUnit.SECONDS).build();
	 * 
	 * private ChatGPT gpt = new
	 * ChatGPT("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", client);;
	 * 
	 * // 30분마다 예약 시간 확인 및 노쇼 처리
	 * 
	 * @Scheduled(cron = "0 30/30 * 1/1 * ?") public void autoNoshow() {
	 * log.info("Spring Scheduler 실행 -> 30분마다 예약 시간 확인 및 노쇼 처리");
	 * mapper.updateReservationStatusByScheduler();
	 * log.info("Spring Scheduler 실행 완료"); }
	 * 
	 * // 30분마다 예약 시간 확인 및 노쇼 처리
	 * 
	 * @Scheduled(cron = "0 30/30 * * 1 *") public void autoOneLine() throws
	 * Exception { log.info("Spring Scheduler 실행 -> 회원 한줄평 작성"); OkHttpClient client
	 * = new OkHttpClient.Builder().readTimeout(120, TimeUnit.SECONDS)
	 * .writeTimeout(120, TimeUnit.SECONDS).build(); ChatGPT gpt = new
	 * ChatGPT("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", client); ;
	 * List<String> list = Dmapper.getMemberList(); String oneline = ""; for (int i
	 * = 0; i < list.size(); i++) { List<String> wineList =
	 * Dmapper.getWineList(list.get(i)); if(wineList == null) { continue; } String
	 * ask = ""; for(int j = 0; j < wineList.size(); j++) { ask += wineList.get(j);
	 * } oneline = gpt.ask(ask +" 와인을 좋아하는 사람을 15자 이상  30자이하로 평가해줘");
	 * oneline.replace(".", "").replace("'", ""); log.info(oneline);
	 * Dmapper.setOneLine(oneline, list.get(i)); log.info(list.get(i) +
	 * " 한줄평 추가 완료"); Thread.sleep(20000); }
	 * log.info("Spring Oneline Scheduler 실행 완료"); }
	 */
}
