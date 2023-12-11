package chap06.Q06;

public abstract class Player {
    private String name ;
    private int jerseyNumber ;
    protected int speed ;
    // Builder 클래스를 정의하시오. (단, static nested class 로 정의하시오.  )
    public static class Builder {
        private Player player;
        public Builder setPlayerType(String position) {
            switch (position) {
                case "forward" -> player = new Forward();
                case "midfielder" -> player = new MidFielder();
                case "defender" -> player = new Defender();
                default -> throw new NullPointerException();
            }
            return this;
        }
        public Builder setName(String name) {
            if (player == null) throw new IllegalArgumentException();
            player.name = name;
            return this;
        }
        public Builder setJerseyNumber(int number) {
            if (player == null) throw new IllegalArgumentException();
            player.jerseyNumber = number;
            return this;
        }
        public Builder setSpeed(int speed) {
            if (player == null) throw new IllegalArgumentException();
            player.setSpeed();
            return this;
        }
        public Player build() {
            return player;
        }
    }
    @Override
    public String toString() {
        return String.format("Player Name='%s, JerseyNumber=%d, SPEED=%d", name, jerseyNumber, speed);
    }

    protected void setSpeed() {}
}
