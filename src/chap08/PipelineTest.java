package chap08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PipelineTest {
    public static void main(String[] args) {
        List<Object> data = new ArrayList<>();
        data.add(10);
        data.add("str");
        data.add(-5.1);
        data.add(-100);
        data.add("var");

        List<String> strData = data.stream()
                .distinct()
                .filter(str -> str instanceof String)
                .map(str -> (String) str)
                .collect(Collectors.toList());
        System.out.println(strData);
    }

}