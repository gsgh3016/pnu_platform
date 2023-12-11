package chap05.Q07;

import java.lang.reflect.*;
import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MyValidator {
    public static Set<String> validate(Object obj){
        Set<String> violations = new HashSet<>();
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field: fields) {
            field.setAccessible(true);
            if (!field.getName().equals("name")) continue;
            try {
                Object value = field.get(obj);
                NotNull notNull = field.getAnnotation(NotNull.class);
                Size size = field.getAnnotation(Size.class);
                if (value == null) {
                    violations.add(notNull.message());
                    continue;
                }
                String name = (String) value;
                if (name.length() < size.min() || name.length() > size.max())
                    violations.add(size.message());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return violations;
    }
}