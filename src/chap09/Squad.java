package chap09;

import java.util.HashMap;
import java.util.Map;

public class Squad {
    private final Map<Position, Player> squad = new HashMap<>();

    public void placePlayer(Position position, Player player) {
        squad.put(position, player);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Player striker = squad.get(Position.STRIKER);
        Player midfielder = squad.get(Position.MIDFIELDER);
        Player defender = squad.get(Position.DEFENDER);
        sb.append("Squad{")
                .append("\n\tPosition: STRIKER, Player: ").append(striker).append(", Stats with Bonus: ").append(striker.calculatePositionBonus(Position.STRIKER))
                .append("\n\tPosition: MIDFIELDER, Player: ").append(midfielder).append(", Stats with Bonus: ").append(midfielder.calculatePositionBonus(Position.MIDFIELDER))
                .append("\n\tPosition: DEFENDER, Player: ").append(defender).append(", Stats with Bonus: ").append(defender.calculatePositionBonus(Position.DEFENDER))
                .append("\n}");
        return sb.toString();
    }
}