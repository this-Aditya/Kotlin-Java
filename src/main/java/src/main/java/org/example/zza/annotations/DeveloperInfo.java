package org.example.zza.annotations;

import java.lang.annotation.Documented;

@Documented
public @interface DeveloperInfo {
    String name() default "NA";
    String language() default "NA";
    String software() default "NA";
    int releaseVersion();
    int branches();
}
