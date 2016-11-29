/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.aspect;

import java.lang.reflect.Method;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.MethodBeforeAdvice;

/**
 *
 * @author Jovana BGD
 */
@Aspect
public class InterceptorLog implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] os, Object o) throws Throwable {
        System.out.println("logBefore() is running!");
        System.out.println("hijacked : " + method.getName());
        System.out.println("******");
    }
}
