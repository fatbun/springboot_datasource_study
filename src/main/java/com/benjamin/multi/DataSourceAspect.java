package com.benjamin.multi;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by Ben Li.
 * Date: 2020/5/28
 */
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(com.benjamin.multi.DataSource)")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource annotation = method.getAnnotation(DataSource.class);
        if (annotation != null) {
            DynamicDataSourceContextHolder.setDataSourceType(annotation.value()
                    .name());
        }
        try {
            return point.proceed();
        } finally {
            DynamicDataSourceContextHolder.clearDataSourceType();
        }

    }

}
