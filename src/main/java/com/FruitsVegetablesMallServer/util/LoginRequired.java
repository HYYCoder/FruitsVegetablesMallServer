package com.FruitsVegetablesMallServer.util;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//加入此注解,就需要token
@Target({ElementType.METHOD, ElementType.TYPE})// 表明此注解可用在方法名上
@Retention(RetentionPolicy.RUNTIME)// 运行时有效
public @interface LoginRequired {
    boolean required() default true;
}