package spring.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.advanced.trace.strategy.code.strategy.ContextV2;
import spring.advanced.trace.strategy.code.strategy.Strategy;
import spring.advanced.trace.strategy.code.strategy.StrategyLogicA;
import spring.advanced.trace.strategy.code.strategy.StrategyLogicB;

@Slf4j
public class ContextV2Test {
    @Test
    void strategyV1() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogicA());
        contextV2.execute(new StrategyLogicB());
    }

    @Test
    void strategyV2() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직A 실행");
            }
        });
        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직B 실행");
            }
        });
    }
}
