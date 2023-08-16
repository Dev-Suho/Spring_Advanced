package spring.advanced.trace.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logicA();
        logicB();
    }

    private void logicA() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직A 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    private void logicB() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직B 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }
}
