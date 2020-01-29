package com.oklimenko.sampleapp.logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker interface for enable custom debug loggin.
 * Useful for Controllers and Services.
 *
 * @author oklimenko@gmail.com
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogMethodStartExit {
}
