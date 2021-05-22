package com.appointment.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ResponseServiceNameFilter extends ZuulFilter  {
    private static final Logger logger = LoggerFactory.getLogger(RequestLogFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        if(requestContext.get("serviceId") != null) {
            String serviceName = requestContext.get("serviceId").toString();
            logger.info("Current service is " + serviceName);

            requestContext.getResponse().addHeader("ServiceName", serviceName);
        }

        return null;
    }
}
