package mini_boot_camp;

class Data {
    int num = 1;
    static int sum = 20;
}

public class HeapEx01 {
    public static void main(String[] args) {
        Data d1 = new Data();
        Data d2 = new Data();
        System.out.println("d1.num: " + d1.num);
        System.out.println("d2.num: " + d2.num);
        System.out.println("Data.sum: " + Data.sum);

        d1.num = 2;

        System.out.println("d1.num: " + d1.num);
        System.out.println("d2.num: " + d2.num);
    }
}
