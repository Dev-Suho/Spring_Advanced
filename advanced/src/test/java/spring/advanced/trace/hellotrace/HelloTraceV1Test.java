package spring.advanced.trace.hellotrace;

import org.junit.jupiter.api.Test;
import spring.advanced.trace.TraceStatus;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV1Test {

    @Test
    void log_begin() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("log start!");
        trace.end(status);
    }

    @Test
    void log_exception() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("log start!");
        trace.exception(status, new IllegalStateException());
    }
 }