package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
public class SelenideLogAspect {
    @Pointcut("execution(public * core.CommonSteps.*(..))")
    public void selenideMethod() { }

    @Pointcut("@annotation(aspects.LogSelenide)")
    public void loggableMethod() {
        //pointcut body, should be empty
    }

    @Pointcut("execution(* *(..))")
    public void anyMethod() {
        //pointcut body, should be empty
    }

    @Before("loggableMethod() && anyMethod()")
    public void logSelenideWithAnnotation(JoinPoint thisJoinPoint) {
        Logger logger = LoggerFactory.getLogger(thisJoinPoint.getSignature().getDeclaringType());
        String methodName = thisJoinPoint.getSignature().getName();
        logger.info("Call method " + methodName + " with args " + Arrays.toString(thisJoinPoint.getArgs()));
    }

    @Before("selenideMethod()")
    public void beforeLogSelenide(JoinPoint thisJoinPoint) {
        Logger logger = LoggerFactory.getLogger(thisJoinPoint.getSignature().getDeclaringType());
        String methodName = thisJoinPoint.getSignature().getName();
        logger.info("Call method " + methodName + " with args " + Arrays.toString(thisJoinPoint.getArgs()));
    }

    @After("selenideMethod()")
    public void afterLogSelenide(JoinPoint thisJoinPoint) {
        Logger logger = LoggerFactory.getLogger(thisJoinPoint.getSignature().getDeclaringType());
        String methodName = thisJoinPoint.getSignature().getName();
        logger.info("method " + methodName + " finished");
    }
}
