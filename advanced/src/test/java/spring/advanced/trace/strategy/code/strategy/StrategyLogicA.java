package spring.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyLogicA implements Strategy{
    @Override
    public void call() {
        log.info("비즈니스 로직A 실행");
    }
}
