package chap07.Q002;

public class MyRectangleSort {
    public static void sort(MyComparable[] elements) {
        for (int i = 0; i < elements.length - 1; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[i].compareTo(elements[j]) < 0) {
                    MyComparable temp = elements[j];
                    elements[j] = elements[i];
                    elements[i] = temp;
                }
            }
        }
    }
}
