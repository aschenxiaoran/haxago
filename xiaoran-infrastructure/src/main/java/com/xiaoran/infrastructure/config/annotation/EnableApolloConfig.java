package com.xiaoran.infrastructure.config.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(ApolloConfigRegister.class)
public @interface EnableApolloConfig {

    String[] value() default {"xiaoran"};
}
