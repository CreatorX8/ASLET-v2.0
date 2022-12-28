package com.creatorx.aslet.interceptor;

import com.creatorx.aslet.dto.RequestMetadata;
import com.creatorx.aslet.exception.NotAuthorizedException;
import com.creatorx.aslet.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtUtils jwtUtils;

    private final RequestMetadata requestMetadata;

    public JwtInterceptor(RequestMetadata requestMetadata) {
        this.requestMetadata = requestMetadata;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null) {
            throw new NotAuthorizedException();
        }
        Claims claims = jwtUtils.validateToken(token);
        requestMetadata.setId(Long.parseLong(claims.getIssuer()));
        requestMetadata.setName(claims.get("name", String.class));
        requestMetadata.setEmail(claims.get("email", String.class));
        requestMetadata.setUsername(claims.getSubject());
        requestMetadata.setRole(claims.get("role", String.class));
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
