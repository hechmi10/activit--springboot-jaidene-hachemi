package tn.esprit.tp_foyer.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AspectProcess {

    @Before("execution(* tn.esprit.tp_foyer.service.FoyerServiceImpl.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("******** In method {} : **********", methodName);
    }

    @After("execution(* tn.esprit.tp_foyer.service.FoyerServiceImpl.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("******** Exiting method {} **********", methodName);
    }

    @Around("execution(* tn.esprit.tp_foyer.service.ReservationServiceImpl.ajouterReservation(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return pjp.proceed();
        }finally {
            long elapsedTime = System.currentTimeMillis()-start;
            String methodName = pjp.getSignature().getName();
            log.info("******** Method [{}] execution time: {} ms",methodName, elapsedTime);
        }

    }
}