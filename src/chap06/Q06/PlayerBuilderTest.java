package chap06.Q06;

public class PlayerBuilderTest {
    public static void main(String[] args) {
        Player p = new Player.Builder().setPlayerType("forward")
                .setName("romelu")
                .setJerseyNumber(9)
                .setSpeed(100)
                .build();
        System.out.println(p);

        p = new Player.Builder().setPlayerType("midfielder")
                .setName("mason")
                .setJerseyNumber(19)
                .setSpeed(100)
                .build();
        System.out.println(p);

        p = new Player.Builder().setPlayerType("defender")
                .setName("kurt")
                .setJerseyNumber(15)
                .setSpeed(100)
                .build();
        System.out.println(p);
    }
}
