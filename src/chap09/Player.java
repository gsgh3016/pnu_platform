package chap09;

import java.util.HashMap;
import java.util.Map;

public abstract class Player {

    private final String name;

    private final int jerseyNumber;

    private Position position;

    final Map<String, Stat> stats;



    protected Player(Builder<?> builder) {

        this.name = builder.name;

        this.jerseyNumber = builder.jerseyNumber;

        this.position = builder.position;

        this.stats = new HashMap<>(builder.stats);

    }



    // Method to calculate the bonus stats based on the player's position

    public abstract Map<String, Stat> calculatePositionBonus(Position squadPosition);



    protected Map<String, Stat> applyBonus(String statName, int bonusValue) {

        Map<String, Stat> newStats = new HashMap<>(this.stats);

        for(Stat stat : newStats.values()) {

            if(stat.getName().equals(statName)) {

                newStats.put(stat.getName(), new Stat(statName, stat.getValue() + bonusValue));

            }

        }

        return newStats;

    }

    @Override

    public String toString() {

        return String.format("Player{name='%s', jerseyNumber=%d, stats=%s}",

                name, jerseyNumber, stats);

    }



    // Static nested Builder class

    public static abstract class Builder<T extends Builder<T>> {

        private String name;

        private int jerseyNumber;

        private Position position;

        private Map<String, Stat> stats = new HashMap<>();



        public T position(Position position) {

            this.position = position;

            return self();

        }

        public T name(String name) {

            this.name = name;

            return self();

        }

        public T jerseyNumber(int jerseyNumber) {

            this.jerseyNumber = jerseyNumber;

            return self();

        }

        public T addStat(Stat stat) {

            stats.put(stat.getName(), stat);

            return self();

        }

        protected abstract T self();

        public abstract Player build();

    }

}