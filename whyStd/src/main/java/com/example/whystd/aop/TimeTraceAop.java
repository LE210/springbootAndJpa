package com.example.whystd.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// Aspect 를 적어줘야 aop로 사용가능
// Component 사용하면 Component 스캔되어 빈 등록
@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* com.example.whystd..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try {
            //joinPoint.proceed() 다음 메소드로 진행
            return joinPoint.proceed();

        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
