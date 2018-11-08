package net.rentalcars.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public final class ReflectionUtils {
	public static Method findMethod(Method method, Class<?> classInstance) {
		for (Method m : classInstance.getDeclaredMethods()) {
			if (m.getName().equals(method.getName())
					&& Arrays.equals(m.getParameterTypes(), method.getParameterTypes())) {
				return m;
			}
		}
		return method;
	}
	public static <T extends Annotation> T findConfigAnnotation(Method method, Class<T> annotationClass) {
		T annotation = method.getAnnotation(annotationClass);
		if (annotation == null) {
			annotation = method.getDeclaringClass().getAnnotation(annotationClass);
		}
		return annotation;
	}
	
	private ReflectionUtils() {
		
	}
}
