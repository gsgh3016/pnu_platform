package mini_boot_camp;

import java.time.LocalDateTime;

class Data1 {
    public void think() throws InterruptedException {
        LocalDateTime start = LocalDateTime.now();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.print(".");
        }
        LocalDateTime end = LocalDateTime.now();
        System.out.println("\n시작시간: " + start);
        System.out.println("끝시간: " + end);
    }
}

public class MethodEx01 {
    public static void main(String[] args) {
        Data1 d1 = new Data1();
        try {
            d1.think();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
