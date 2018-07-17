package cdu.xeon.forum.auth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface AuthMethod {
	public String role() default "base";
}
