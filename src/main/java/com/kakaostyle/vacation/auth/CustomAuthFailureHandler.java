package com.kakaostyle.vacation.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.kakaostyle.vacation.auth.LoginErrorCode.*;

@Component
class CustomAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception
    ) throws IOException, ServletException {

        String redirectUrl = "/templates/auth/login?error=true&code=";
        int code;


        if (exception instanceof UsernameNotFoundException) {
            code = USER_NOT_FOUND.getCode();
        } else if (exception instanceof InternalAuthenticationServiceException) {
            code = INTERNAL_ERROR.getCode();
        } else if (exception instanceof BadCredentialsException) {
            code = INVALID_ID_PASSWORD.getCode();
        } else {
            code = ELSE_ERROR.getCode();
        }

        setDefaultFailureUrl(redirectUrl + code);
        super.onAuthenticationFailure(request, response, exception);
    }


}
