package ua.in.dris4ecoder.SimpleCalculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
class LogAspect {

    public static final Logger logger = LogManager.getLogger();

    @Before("execution(* Calculator.compute(String)) && args(expression)")
    public void onComputeBefore(String expression) {
        logger.info("Calculator: Method operate with expression: '" + expression + "'");
    }

    @Around(value = "execution(* ua.in.dris4ecoder.SimpleCalculator.Calculator.compute(String))")
    public Object onCompute(ProceedingJoinPoint pjp) throws Throwable {

        logger.traceEntry("Calculator: Method '" + pjp.getSignature().getName() + "' called with parameters: " + Arrays.toString(pjp.getArgs()));
        Object result = pjp.proceed();
        logger.traceExit("Calculator: Method '" + pjp.getSignature().getName() + "' is finished");
        return result;
    }

    @AfterThrowing(pointcut = "execution(* ua.in.dris4ecoder.SimpleCalculator.Calculator.compute(String)) && args(expression)", throwing = "exception")
    public void onComputeExceptions(String expression, Throwable exception) throws Throwable {

        logger.error("Calculator: Thrown exception: " + exception + ". Expression: '" + expression + "'");
    }

    @AfterReturning(pointcut = "execution(* Calculator.compute(String)) && args(expression)", returning = "result", argNames = "expression,result")
    public void onComputeOk(String expression, double result) {

        logger.info("Calculator: Expression '" + expression + "' calculated successful. Result = " + result);
    }

    @Before("execution(* ua.in.dris4ecoder.SimpleCalculator.Parser.parse(String)) && args(expression)")
    public void onParseBefore(String expression) throws Throwable {

        logger.info("Parser: Expression '" + expression + "' is processed...");
    }

    @AfterThrowing(pointcut = "execution(* Parser.parse(String)) && args(expression)", throwing = "except")
    public void onParseAfterThrowing(String expression, Throwable except) {
        logger.error("Parser: Thrown exception: " + except + ". '"+ expression + "' can not be processed");
    }

    @AfterReturning(pointcut = "execution(* Parser.parse(String)) && args(expression)")
    public void onParserAfterReturning(String expression) {
        logger.info("Parser: Expression '" + expression + "' parsed successful");
    }
}
