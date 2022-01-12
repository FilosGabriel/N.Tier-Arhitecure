package com.filos.api.annotations.web;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@RestController
public @interface ApiController {

    @AliasFor(annotation = RestController.class, attribute = "value")
    String path() default "";
}
