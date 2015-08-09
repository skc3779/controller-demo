package comm.aspect;

/**
 * Created by skc37_000 on 2015-08-07.
 */

import java.lang.reflect.Method;

import comm.data.ResultData;
import comm.except.BusinessException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Aspect
public class RestControllerAdvisor {
    private static final Logger log = LoggerFactory.getLogger(RestControllerAdvisor.class);

    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.ResponseBody)")
    //@Pointcut(value = "execution(* business..*Controller.json*(..))")
    private void restController() {
        //NOTE : pointcut : @RestController
        log.info("RestControllerAdvisor....");
    }

    @Around("restController()")
    public Object wrapResponseObject(ProceedingJoinPoint pjp) throws Throwable {
        try {
            if(log.isInfoEnabled()) {
                Method method = ((MethodSignature) pjp.getSignature()).getMethod();
                RequestMapping requestMapping = method.getDeclaredAnnotation(RequestMapping.class);
                log.info("api-call start : " + requestMapping.value()[0]);
            }
            Object ret = pjp.proceed();
            if(log.isInfoEnabled()) {
                Method method = ((MethodSignature) pjp.getSignature()).getMethod();
                RequestMapping requestMapping = method.getDeclaredAnnotation(RequestMapping.class);
                log.info("api-call completed : " + requestMapping.value()[0]);
            }
            return new ResultData(ret);
        } catch(BusinessException ex) {
            log.error(ex.getMessage(), ex);
            log.debug("LogicException", ex);
            return new ResultData(ex);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            log.debug("Exception", ex);
            return new ResultData(ex);
        }
    }
}
