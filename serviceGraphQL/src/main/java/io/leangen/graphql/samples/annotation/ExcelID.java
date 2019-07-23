package io.leangen.graphql.samples.annotation;

import java.lang.annotation.*;

/**
 * @author Wings
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ExcelID {
    String value() default "";
}
