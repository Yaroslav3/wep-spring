package com.example.ua.mongodbsecurity.filter;

import com.example.ua.mongodbsecurity.service.impl.TokenAuthService;
import com.sun.istack.internal.NotNull;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;



public class StatelessAuthFilter extends GenericFilterBean {
    private final TokenAuthService tokenAuthService;

    public StatelessAuthFilter(@NotNull TokenAuthService tokenAuthService) {
        this.tokenAuthService = tokenAuthService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(
                tokenAuthService.getAuthentication((HttpServletRequest) servletRequest).orElse(null));
        filterChain.doFilter(servletRequest, servletResponse);
    }

}

//    @Autowired
//    private UserService userService;
//
//    private User admin;
//
//    @PostConstruct
//    public void init() {
//        admin = (User) userService.loadUserByUsername("admin");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        SecurityContextHolder.getContext().setAuthentication(new UserAuthentication(admin));
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//}
