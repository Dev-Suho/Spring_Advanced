package spring.advanced.app.v5;

import org.springframework.stereotype.Service;
import spring.advanced.trace.callback.TraceTemplate;
import spring.advanced.trace.logtrace.LogTrace;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;

    private final TraceTemplate trace;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.trace = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {

        trace.execute("OrderService,orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
