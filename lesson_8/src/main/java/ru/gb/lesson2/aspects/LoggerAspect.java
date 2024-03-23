package ru.gb.lesson2.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
    /**
     * Логирование как отработали методы
     * @param joinPoint Входная точка
     * @param returning что вернул вызываемый метод
     */
    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returning")
    public void  logging(JoinPoint joinPoint, Object returning) {
        System.out.println("Method " + joinPoint.getSignature().getName() + " was called. Returning: " + returning.getClass());
    }

    /**
     * Логирование методов в которых были выброшены исключения
     * @param joinPoint Входная точка
     * @param ex Исключение в вызываемом методе
     */
    @AfterThrowing(value = "@annotation(TrackUserAction)", throwing = "ex")
    public void loggingException(JoinPoint joinPoint, Exception ex) {
        System.out.println("Method " + joinPoint.getSignature().getName() + " was called. Exception: " + ex.getClass() + "message: " + ex.getMessage());
    }
}