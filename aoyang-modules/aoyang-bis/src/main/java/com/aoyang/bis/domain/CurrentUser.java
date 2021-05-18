package com.aoyang.bis.entity;

import java.lang.annotation.*;

/**
 * @author GC
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser{
}