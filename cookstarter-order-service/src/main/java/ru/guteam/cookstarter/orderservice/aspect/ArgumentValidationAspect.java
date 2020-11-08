package ru.guteam.cookstarter.orderservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import ru.guteam.cookstarter.api.dto.orderservice.OrderDto;
import ru.guteam.cookstarter.orderservice.exception.OrderProcessingException;

@Aspect
@Configuration
public class ArgumentValidationAspect {

    @Before(value = "execution(* * (java.lang.Long, ..))" +
            "&& @annotation(ru.guteam.cookstarter.orderservice.aspect.annotation.CheckIdIsNotNull)")
    public void idNotNull(JoinPoint joinPoint) {
        Long id = (Long) joinPoint.getArgs()[0];
        if (id == null) {
            throw new OrderProcessingException("Не указан id");
        }
    }

    @Before(value = "execution(* * (ru.guteam.cookstarter.api.dto.orderservice.OrderDto, ..))" +
            "&& @annotation(ru.guteam.cookstarter.orderservice.aspect.annotation.CheckIdIsNotNull)")
    public void orderIdNotNull(JoinPoint joinPoint) {
        OrderDto orderDto = (OrderDto) joinPoint.getArgs()[0];
        if (orderDto.getId() == null) {
            throw new OrderProcessingException("Не указан id");
        }
    }
}
