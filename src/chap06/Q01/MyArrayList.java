package chap06.Q01;

public class MyArrayList<T> {
    Object[] array;
    int size = 0;
    int capacity;

    public MyArrayList(int capacity) {
        this.array = new Object[capacity];
        this.capacity = capacity;
    }

    public void add(T data) {
        if (this.size >= this.capacity)
            throw new ArrayStoreException("Too much elements in Array");
        this.array[size++] = data;
    }

    public T get(int index) {
        if (index >= this.size)
            throw new ArrayIndexOutOfBoundsException(String.format("Index %d is out of bounds", index));
        if (this.array[index] == null)
            throw new NullPointerException(String.format("No data in index: %d", index));
        T data = (T) this.array[index];
        return data;
    }
}
