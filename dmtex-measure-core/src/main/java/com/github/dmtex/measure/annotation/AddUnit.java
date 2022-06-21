package com.github.dmtex.measure.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code AddUnit} annotation is used to mark fields containing units to be added to the system of units.
 *
 * @author Denis Murashev
 *
 * @since Measure 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddUnit {
}
