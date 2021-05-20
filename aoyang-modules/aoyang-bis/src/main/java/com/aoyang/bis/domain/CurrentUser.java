package com.aoyang.bis.domain;

import java.lang.annotation.*;

/**
 * @author GC
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser{
}