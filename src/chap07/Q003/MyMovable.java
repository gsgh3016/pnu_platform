package chap07.Q003;

public interface MyMovable {
    default String moveBy() {
        return "나는 출근한다.";
    }
}
