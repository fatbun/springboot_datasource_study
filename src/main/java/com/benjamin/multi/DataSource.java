package com.benjamin.multi;

import java.lang.annotation.*;

/**
 * Created by Ben Li.
 * Date: 2020/5/28
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    DataSourceType value() default DataSourceType.SLAVE;
}
