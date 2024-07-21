# Scheduled

<br/><br/><br/>



## Index

---

* [Scheduled Batch](#Scheduled-Batch)
* [Annotation Options](#Annotation-Options)

<br/><br/><br/>



### Scheduled Batch

---

> @Scheduled()

```java
@Component
@EnableScheduling // 스프링 컨테이너에게 Scheduling 한다고 알림
public class ScheduledComponent {
    
    @Scheduled()
    public void schedule() { }
}
```

Spring `@Scheduled` 어노테이션을 사용하여 스케쥴링 하는 방법이다.  

Spring Bean ComponentScan 대상이여서  
스케쥴 배치 클래스가 컴포넌트 스캔 대상이 될 수 있도록 `@Component`를 선언해 주어야 한다.  
그리고 스케줄을 사용하겠다라고 스프링이 인식해줄 수 있도록 `@EnableScheduling` 을 선언해 주어야 한다.

참고로 SpringBoot 내부에 Task Scheduler 라이브러리가 존재한다. (내장이다.)  
그래서 maven 또는 gradle로 dependency를 가져오지 않아도 된다.

<br/><br/><br/>



### Annotation Options

---

| 옵션               |      타입 | 설명                                                 |
|--------------------|--------:|:---------------------------------------------------|
| fixedDelay         |    long | millisecond 단위로   long 타입으로 주기적으로 실행               |
| fixedDelayString   |  String | millisecond 단위로 String 타입으로 주기적으로 실행               |
| fixedRate          |    long | millisecond 단위로   long 타입으로 주기적으로 실행               |
| fixedRateString    |  String | millisecond 단위로 String 타입으로 주기적으로 실행               |
| initialDelay       |    long | Spring 실행시 millisecond 단위로   long 타입으로 대기 후 스케쥴 실행 |
| initialDelayString |  String | Spring 실행시 millisecond 단위로 String 타입으로 대기 후 스케쥴 실행 |
| cron               |      -- | 특정 시간에 실행될 수 있도록 스케줄 시간을 설정한다.                  |
| zone               |      -- | cron과 함꼐 사용되며, cron 설정 시간의 국가를 설정한다.               |

> fixedDelay와 flxedRate 의 차이 

둘이 보면 옵션명이 비슷해 혼란이 있을 수 있다.  
혹시 몰라 정리해 놓는다.

* fixedDelay
  * 특정 작업을 기다린 후 설정한 시간이 지난 후 배치를 실행
* fixedRate
  * 특정 작업의 결과를 기다리지 않고 설정한 시간대로 배치를 실행

<br/><br/><br/>

