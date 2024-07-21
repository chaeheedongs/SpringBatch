package com.study.SpringBatch.a_scheduled;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling // 스프링 컨테이너에게 Scheduling 한다고 알림
public class ScheduledComponent {

    /**
     * @Scheduled() ----------------
     * ## 실행 시간 설정
     * fixedDelay: long =>            millisecond 단위로   long 타입으로 주기적으로 실행
     * fixedDelayString: String =>    millisecond 단위로 String 타입으로 주기적으로 실행
     * fixedRate : long =>            millisecond 단위로   long 타입으로 주기적으로 실행
     * fixedRateString : String =>    millisecond 단위로 String 타입으로 주기적으로 실행
     * ----------------
     * ## 시작 시간 딜레이 설정
     * initialDelay: long =>          Spring 실행시 millisecond 단위로   long 타입으로 대기 후 스케쥴 실행
     * initialDelayString: String =>  Spring 실행시 millisecond 단위로 String 타입으로 대기 후 스케쥴 실행
     * ----------------
     * ## Cron 표현식 사용
     * #             초 분 시 일 월 요일
     * Scheduled(cron = "* * * * * *")
     * #                               국가 시간 설정
     * Scheduled(cron = "* * * * * *", zone="Asia/Seoul")
     */

    boolean execJob = false;

    @Scheduled(fixedDelay = 1000)
    public void fixedDelayjob() {
        if (execJob) {
            System.out.println("### Fixed Delay Batch Run !");
        }
    }

    @Scheduled(fixedRate = 1000)
    public void fixedRateJob() {
        if (execJob) {
            System.out.println("### Fixed Rate Batch Run !");
        }
    }

    /* 초 분 시 일 월 요일 */
    @Scheduled(cron = "* * * * * *")
    public void cronJob() {
        if (execJob) {
            System.out.println("### Cron Batch Run !");
        }
    }
}
