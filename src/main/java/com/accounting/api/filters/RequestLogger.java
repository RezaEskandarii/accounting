package com.accounting.api.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class RequestLogger implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLogger.class);

    private static final ThreadLocal<RequestContext> REQUEST_CONTEXT = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Create a new RequestContext for this request
        UUID requestId = UUID.randomUUID();
        RequestContext context = new RequestContext(requestId, System.currentTimeMillis());
        REQUEST_CONTEXT.set(context);

        // Log the request details
        LOGGER.info("Request received - requestId: {}, method: {}, IP: {}, URI: {}",
                requestId, request.getMethod(), request.getRemoteAddr(), request.getRequestURI());

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Get the RequestContext for this request
        RequestContext context = REQUEST_CONTEXT.get();

        // Calculate request duration
        long duration = System.currentTimeMillis() - context.getStartTime();

        // Log the response details
        LOGGER.info("Request completed - requestId: {}, status code: {}, duration: {} ms",
                context.getRequestId(), response.getStatus(), duration);
        System.out.println("***********************");
        // Remove the RequestContext from the ThreadLocal
        REQUEST_CONTEXT.remove();
    }

    private static class RequestContext {
        private final UUID requestId;
        private final long startTime;

        public RequestContext(UUID requestId, long startTime) {
            this.requestId = requestId;
            this.startTime = startTime;
        }

        public UUID getRequestId() {
            return requestId;
        }

        public long getStartTime() {
            return startTime;
        }

        @Override
        public String toString() {
            return "RequestContext{" +
                    "requestId=" + requestId +
                    ", startTime=" + startTime +
                    '}';
        }
    }
}