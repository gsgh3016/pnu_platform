package edu.pnu.myspring.core;

import edu.pnu.myspring.annotations.*;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class MyApplicationContext {
    private Map<Class<?>, Object> beanRegistry = new HashMap<>();
    private List<Object> beansToAutowire = new ArrayList<>();
    private Map<Object, Method> postConstructMethodRegistry = new HashMap<>();
    private Map<Object, Method> preDestroyMethodRegistry = new HashMap<>();

    public MyApplicationContext(String basePackage) {
        scanAndRegisterBeans(basePackage);
        processAutowiring();
    }

    private void scanAndRegisterBeans(String basePackage) {
        String path = basePackage.replace('.', '/');
        URL resource = Thread.currentThread().getContextClassLoader().getResource(path);

        if (resource == null) return;

        File directory = new File(resource.getFile());

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) {
                scanAndRegisterBeans(basePackage + '.' + file.getName());
            } else if (file.getName().endsWith(".class")) {
                String className = basePackage + '.' + file.getName().substring(0, file.getName().length() - 6);
                try {
                    Class<?> clazz = Class.forName(className);

                    if (clazz.isAnnotationPresent(MyRestController.class) ||
                            clazz.isAnnotationPresent(MyService.class) ||
                            clazz.isAnnotationPresent(MyRepository.class)) {
                        registerBean(clazz);
                    }

                } catch (Exception e) {
                    throw new RuntimeException("Failed to scan class", e);
                }
            }
        }
    }

    public <T> void registerBean(Class<? extends T> beanClass) {
        try {
            T beanInstance = beanClass.getDeclaredConstructor().newInstance();

            for (Method method: beanClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(PostConstruct.class)) {
                    postConstructMethodRegistry.put(beanInstance, method);
                } else if (method.isAnnotationPresent(PreDestroy.class)) {
                    preDestroyMethodRegistry.put(beanInstance, method);
                }
            }

            beanRegistry.put(beanClass, beanInstance);

            if (postConstructMethodRegistry.containsKey(beanInstance)) {
                postConstructMethodRegistry.get(beanInstance).invoke(beanInstance);
            }
            beansToAutowire.add(beanInstance);
        } catch (Exception e) {
            throw new RuntimeException("Failed to register bean", e);
        }
    }

    private void processAutowiring() {
        for (Object bean: beansToAutowire) {
            for (Field field: bean.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(MyAutowired.class)) {
                    Object dependency = getBean(field.getType());
                    field.setAccessible(true);

                    try {
                        field.set(bean, dependency);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to inject dependency into field", e);
                    }
                }
            }
        }
    }

    public <T> T getBean(Class<T> type) {
        return type.cast(beanRegistry.get(type));
    }

    public void close() {
        for (Map.Entry<Object, Method> entry: preDestroyMethodRegistry.entrySet()) {
            try {
                entry.getValue().invoke(entry.getKey());
            } catch (Exception e) {
                throw new RuntimeException("Failed to execute @PreDestroy method for bean of class: " + entry.getKey().getClass().getName(), e);
            }
        }

        beanRegistry.clear();
    }
}
