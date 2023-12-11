package chap09;

import java.util.Map;

public class Striker extends Player {
    protected Striker(Builder builder) {
        super(builder);
    }

    @Override
    public Map<String, Stat> calculatePositionBonus(Position squadPosition) {
        if (squadPosition == Position.STRIKER) {
            return applyBonus("Shooting", 10);
        }
        return stats;
    }

    @Override
    protected Map<String, Stat> applyBonus(String statName, int bonusValue) {
        return super.applyBonus(statName, bonusValue);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static class Builder extends Player.Builder {
        @Override
        public Player.Builder position(Position position) {
            super.position(position);
            return self();
        }

        @Override
        public Player.Builder name(String name) {
            super.name(name);
            return self();
        }

        @Override
        public Player.Builder jerseyNumber(int jerseyNumber) {
            super.jerseyNumber(jerseyNumber);
            return self();
        }

        @Override
        public Player.Builder addStat(Stat stat) {
            super.addStat(stat);
            return self();
        }

        @Override
        protected Player.Builder self() {
            return this;
        }

        @Override
        public Player build() {
            return new Striker(this);
        }
    }
}