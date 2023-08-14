package spring.advanced.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.advanced.trace.threadlocal.code.FieldService;
import spring.advanced.trace.threadlocal.code.ThreadLocalService;

@Slf4j
public class ThreadLocalServiceTest {

    ThreadLocalService service = new ThreadLocalService();

    @Test
    void field() {
        log.info("userA start");;
        Runnable userA = () -> {
            service.logic("userA");
        };
        Runnable userB = () -> {
            service.logic("userB");
        };
        Runnable userC = () -> {
            service.logic("userC");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("threadA");
        Thread threadB = new Thread(userB);
        threadA.setName("threadC");
        Thread threadC = new Thread(userC);
        threadA.setName("threadC");

        threadA.start();
        sleep(2000);
        threadB.start();
        sleep(2000);
        threadC.start();
        sleep(2000);
        log.info("Thread exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
