package com.xiaoran.infrastructure.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Scope("prototype")
public @interface AggragateRoot {
}
