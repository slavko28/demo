package com.toptop.config;

import com.toptop.domain.CurrentUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        switch (currentUser.getRole()) {
            case ADMIN:
                httpServletResponse.sendRedirect("/admin");
                break;
            case MANAGER:
                httpServletResponse.sendRedirect("/manager");
                break;
            case ACCOUNTANT:
                httpServletResponse.sendRedirect("/accountant");
                break;
            default:
                httpServletResponse.sendRedirect("/");
        }
    }
}
