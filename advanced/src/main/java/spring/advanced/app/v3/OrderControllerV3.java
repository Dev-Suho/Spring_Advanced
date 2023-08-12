package spring.advanced.app.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.hellotrace.HelloTraceV2;
import spring.advanced.trace.logtrace.LogTrace;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId) {

        TraceStatus status = null;
        try {
            //trace 정보
            status = trace.begin("OrderControllerV3.request()");
            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);
            return "item";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
