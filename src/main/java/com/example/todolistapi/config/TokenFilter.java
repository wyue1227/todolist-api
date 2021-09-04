
package com.example.todolistapi.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {

    // private static final Set<String> ALLOWED_PATHS = Collections
    // .unmodifiableSet(new HashSet<>(Arrays.asList("/main/excludefilter", "/login",
    // "/logout", "/register")));

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println(request);
        // String path =
        // request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$",
        // "");
        boolean allowedPath = false; // ALLOWED_PATHS.contains(path);

        if (allowedPath) {
            System.out.println("这里是不需要处理的url进入的方法");
            chain.doFilter(req, res);
        } else {
            System.out.println("这里是需要处理的url进入的方法");
            String token = request.getHeader("token");
            System.out.println("token: " + token);
            if ("12345".equals(token)) {
                System.out.println("token校验成功");
                chain.doFilter(req, res);
            } else {
                return;
            }
        }
    }

}