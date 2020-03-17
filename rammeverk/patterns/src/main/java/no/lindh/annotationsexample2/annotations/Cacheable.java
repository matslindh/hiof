package no.lindh.annotationsexample2.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Cacheable {
    int ttl() default 5;
}
