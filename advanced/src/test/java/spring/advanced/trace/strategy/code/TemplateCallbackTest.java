package spring.advanced.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.advanced.trace.strategy.code.template.CallBack;
import spring.advanced.trace.strategy.code.template.TimeLogTemplate;

@Slf4j
public class TemplateCallbackTest {

    @Test
    void callBackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new CallBack() {
            @Override
            public void call() {
                log.info("비즈니스 로직A 실행");
            }
        });
        
        template.execute(new CallBack() {
            @Override
            public void call() {
                log.info("비즈니스 로직B 실행");
            }
        });
    }

    @Test
    void callBackV2() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("비즈니스 로직A 실행"));
        template.execute(() -> log.info("비즈니스 로직B 실행"));
    }

}
