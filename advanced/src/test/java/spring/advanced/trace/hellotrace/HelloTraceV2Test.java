package spring.advanced.trace.hellotrace;

import org.junit.jupiter.api.Test;
import spring.advanced.trace.TraceStatus;

class HelloTraceV2Test {

    @Test
    void log_begin() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("log start!");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "log level2");
        trace.end(status2);
        trace.end(status);
    }

    @Test
    void log_exception() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("log start!");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "log level2");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status, new IllegalStateException());
    }
 }