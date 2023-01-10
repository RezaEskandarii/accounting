package com.accounting.config;

import com.accounting.commons.TenantContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
@Slf4j
public class TenantFilter implements Filter {

    private final String tenantId = "X-TenantID";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        var req = (HttpServletRequest) request;
        //  log.info(req.toString());
        // System.out.println(req.toString());
        //  var tenantIdStr = req.getHeader(tenantId);
//        if ("".equals(tenantIdStr) || tenantIdStr == null) {
//            throw new ServletException("X-TenantId header is null");
//        } else {
        TenantContext.setCurrentTenant("1");
        chain.doFilter(request, response);
//        }
    }

    // other methods
}