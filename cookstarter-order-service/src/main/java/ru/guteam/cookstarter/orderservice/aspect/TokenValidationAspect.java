package ru.guteam.cookstarter.orderservice.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import ru.guteam.cookstarter.orderservice.service.JwtValidationService;

@Slf4j
@Aspect
@Configuration
@RequiredArgsConstructor
public class TokenValidationAspect {

    private final JwtValidationService jwtValidationService;

    @Before("execution(* ru.guteam.cookstarter.orderservice.controller.OrderController.* (*, java.lang.String))")
    public void tokenCheck(JoinPoint joinPoint) {
        String token = (String) joinPoint.getArgs()[1];
        log.info("Проверка токена");
        jwtValidationService.checkToken(token);
    }
}
