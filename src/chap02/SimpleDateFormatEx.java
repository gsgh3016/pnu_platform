package chap02;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleDateFormatEx {
    public static void main(String[] args) {
        Date now = new Date(); // 현재 시간
        System.out.println(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E", Locale.KOREA);
        System.out.println(sdf.format(now));
    }
}