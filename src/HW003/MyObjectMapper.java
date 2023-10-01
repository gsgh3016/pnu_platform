package HW003;

import java.lang.reflect.*;

public class MyObjectMapper {
    private MyJsonParser parser;

    public MyObjectMapper() {
        this.parser = new MyJsonParser();
    }

    public <T> T readValue(String jsonString, Class<T> clazz) throws Exception {
        // implement your code using Java Reflection
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        var map = this.parser.parse(jsonString);
        T instance = constructor.newInstance();

        final Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            field.setAccessible(true);
            Object value = map.get(field.getName());
            if (value.getClass().equals(field.getType())) {
                field.set(instance, value);
            } else if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {
                field.set(instance, Integer.parseInt((String) value));
            } else if (field.getType().equals(double.class) || field.getType().equals(Double.class)) {
                field.set(instance, Double.parseDouble((String) value));
            }
        }
        return instance;
    }
}