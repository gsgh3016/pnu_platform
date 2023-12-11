package chap07.Q005;

@FunctionalInterface
public interface MyFunction {
    static MyFunction getMyFunction(String name) {
        return () -> System.out.println(name + ".run()");
    }

    void run();

    default void sayHello() {
        System.out.println("Hello");
    }
}
