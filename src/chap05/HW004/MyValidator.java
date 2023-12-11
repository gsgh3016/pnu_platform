package chap05.HW004;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class MyValidator {
    public static Set<String> validate(Object obj) throws IllegalAccessException {
        Set<String> violations = new HashSet<>();
        Class<?> objClass = obj.getClass();
        while (objClass != null) {
            for (Field field : objClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class)) {
                    if (field.get(obj) == null) {
                        NotNull notNull = field.getAnnotation(NotNull.class);
                        violations.add(notNull.message());
                    }
                }
                if (field.isAnnotationPresent(Size.class)) {
                    Size size = field.getAnnotation(Size.class);
                    String fieldValue = (String) field.get(obj);
                    if (fieldValue != null && (fieldValue.length() < size.min() || fieldValue.length() > size.max())) {
                        violations.add(size.message());
                    }
                }
                if (field.isAnnotationPresent(Email.class)) {
                    Email email = field.getAnnotation(Email.class);
                    String fieldValue = (String) field.get(obj);
                    if (!fieldValue.matches("^[A-Za-z0-9._%+-]{3,}@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                        violations.add(email.message());
                    }
                }
            }
            objClass = objClass.getSuperclass();
        }
        return violations;
    }
}
