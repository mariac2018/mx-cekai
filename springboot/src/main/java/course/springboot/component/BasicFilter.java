package course.springboot.component;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(filterName = "basicFilter")
public class BasicFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasicFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) request;
        LOGGER.info("BasicFilter start,url={}",httpServletRequest.getRequestURI());
        chain.doFilter(request,response);
    }
}
