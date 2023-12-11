package chap09;

public class PlayerBuilderTest {

    public static void main(String[] args) {

        Player striker = new Striker.Builder()

                .name("HeungMin Son")

                .jerseyNumber(7)

                .addStat(new Stat("Speed", 90))

                .addStat(new Stat("Shooting", 85))

                .build();



        Player midfielder = new Midfielder.Builder()

                .name("Jordan Henderson")

                .jerseyNumber(10)

                .addStat(new Stat("Passing", 88))

                .addStat(new Stat("Stamina", 90))

                .build();



        Player defender = new Defender.Builder()

                .name("MinJae Kim")

                .jerseyNumber(3)

                .addStat(new Stat("Defense", 92))

                .addStat(new Stat("Strength", 89))

                .build();



        Squad squad = new Squad();

        squad.placePlayer(Position.STRIKER, striker);

        squad.placePlayer(Position.MIDFIELDER, midfielder);

        squad.placePlayer(Position.DEFENDER, defender);

        System.out.println(squad);



        Squad newSquad = new Squad();

        newSquad.placePlayer(Position.DEFENDER, striker);

        newSquad.placePlayer(Position.STRIKER, midfielder);

        newSquad.placePlayer(Position.MIDFIELDER, defender);

        System.out.println(newSquad);

    }

}
