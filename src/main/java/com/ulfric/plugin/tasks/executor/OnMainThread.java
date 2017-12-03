package com.ulfric.plugin.tasks.executor;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.ulfric.dragoon.extension.intercept.asynchronous.Asynchronous;

@Retention(RUNTIME)
@Target({ FIELD, METHOD, ANNOTATION_TYPE })
@Asynchronous(EnsureMainThreadExecutorSupplier.class)
public @interface OnMainThread {

}
