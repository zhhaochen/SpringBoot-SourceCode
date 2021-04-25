package ch1.ch3_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect // 声明一个切面
@Component // 让这个切面成为spring管理的容器
public class LogAspect {

    // 定义切点，切点方法里要求为空
    @Pointcut("@annotation(ch1.ch3_aop.Action)")
    public void annotationPointCut(){}

    // 使用切点，
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        // 获取被代理类信息
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        // 获取方法
        Method method = signature.getMethod();
        // 获取方法上的注解
        Action annotation = method.getAnnotation(Action.class);
        System.out.println("注解式拦截：" + annotation.name());
    }

    // 注意第一个 * 后面的空格
    @Before("execution(* ch1.ch3_aop.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        // 获取被代理类信息
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        // 获取方法
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截" + method.getName());
    }

}
