package com.repaso.repaso.security;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;


@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, jakarta.servlet.ServletException {
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                if (auth != null) {
                    System.out.println("User '" + auth.getName()
                            + "' attempted to access the protected URL: "
                            + request.getRequestURI());
                }
        
                response.sendRedirect(request.getContextPath() + "/acceso-denegado");
    }

}
