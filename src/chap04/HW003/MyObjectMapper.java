package chap04.HW003;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Map;

public class MyObjectMapper {
    private MyJsonParser myJsonParser;

    public MyObjectMapper() {
        this.myJsonParser = new MyJsonParser();
    }

    public <T> T readValue(String jsonString, Class<T> clazz) throws Exception {
        Map<String, Object> map = myJsonParser.parse(jsonString);
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        T t = constructor.newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            if (map.containsKey(field.getName())) {
                field.setAccessible(true);
                Object value = map.get(field.getName());
                Object convertedValue = convertValue(value, field.getType());
                field.set(t, convertedValue);
            }
        }

        return t;
    }

    private Object convertValue(Object value, Class<?> type) {
        if (type.isPrimitive()) {
            if (type.equals(int.class)) {
                return Integer.parseInt(value.toString());
            }
            if (type.equals(double.class)) {
                return Double.parseDouble(value.toString());
            }
        }
        return value;
    }
}