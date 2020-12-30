package com.lxb.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lixiaobing
 * @date 2020-12-28 15:22
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcService {
    String service();

    String group() default "default";

    String version() default "default";

    String tags() default "";

    int weight() default 1;
}
