package spring.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.advanced.trace.strategy.code.strategy.ContextV1;
import spring.advanced.trace.strategy.code.strategy.StrategyLogicA;
import spring.advanced.trace.strategy.code.strategy.StrategyLogicB;

@Slf4j
public class ContextV1Test {

    @Test
    void strategy() {
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

    @Test
    void strategyV1() {
        StrategyLogicA strategyLogicA = new StrategyLogicA();
        ContextV1 contextV1 = new ContextV1(strategyLogicA);
        contextV1.execute();

        StrategyLogicB strategyLogicB = new StrategyLogicB();
        ContextV1 contextV2 = new ContextV1(strategyLogicB);
        contextV2.execute();
    }
}
