package com.fm.repository;

import com.fm.unit.Player;

import java.util.Arrays;
import java.util.List;

public class PlayerFactory {
    public static Player createPlayersWithoutID(String[] fields) {
        String name = fields[Player.NAME - 1].trim();
        int height = Integer.parseInt(fields[Player.HEIGHT - 1].trim());
        String nationality = fields[Player.NATIONALITY - 1].trim();
        String club = fields[Player.CLUB - 1].trim();
        int overall = Integer.parseInt(fields[Player.OVERALL - 1].trim());
        List<String> positions = Arrays.asList(fields[Player.POSITION - 1].replace("\"", "").split(", "));

        return new Player(name, height, nationality, club, overall, positions);
    }

    public static Player createPlayers(String[] fields) {
        int id = Integer.parseInt(fields[Player.ID].trim());
        String name = fields[Player.NAME].trim();
        int height = Integer.parseInt(fields[Player.HEIGHT].trim());
        String nationality = fields[Player.NATIONALITY].trim();
        String club = fields[Player.CLUB].trim();
        int overall = Integer.parseInt(fields[Player.OVERALL].trim());
        List<String> positions = Arrays.asList(fields[Player.POSITION].replace("\"", "").split(", "));

        return new Player(id, name, height, nationality, club, overall, positions);
    }
}