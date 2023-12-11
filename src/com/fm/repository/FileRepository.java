package com.fm.repository;

import com.fm.unit.Player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FileRepository implements IRepository {
    public static final String[] FILE_HEADER =
            { "sofifa_id", "short_name", "height_cm", "nationality", "club", "overall", "player_positions", "\n" };
    private static FileRepository instance = new FileRepository();
    public final String FILENAME =
            Thread.currentThread().getContextClassLoader().getResource("players_20_short.csv").getFile();
    private boolean loaded = false;
    private List<Player> players;

    private FileRepository(){
        load();
    }

    private void load() {
        Path path = Paths.get(FILENAME);
        players = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                if (!line.trim().isEmpty()) {
                    String[] fields = line.split(",");
                    Player player = create(fields);
                    players.add(player);
                }
            }
            loaded = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileRepository getInstance() {return instance;}

    private Player create(String[] fields) {
        return PlayerFactory.createPlayers(fields);
    }

    @Override
    public int count() {
        return players.size();
    }

    @Override
    public void save(Player t) {
        if (!loaded) load();
        players.add(t);
        writeFile();
    }

    @Override
    public void delete(Player t) {
        if (!loaded) load();
        players.remove(t);
        writeFile();
    }

    @Override
    public void deleteById(int id) {
        if (!loaded) load();
        players.removeIf(player -> player.getId() == id);
        writeFile();
    }

    @Override
    public boolean existsById(int id) {
        return players.stream().anyMatch(player -> player.getId() == id);
    }

    @Override
    public Iterable<Player> findAll() {
        if (!loaded) load();
        return players;
    }

    @Override
    public Optional<Player> findById(int id) {
        if (!loaded) load();
        return players.stream()
                .filter(player -> player.getId() == id)
                .findFirst();
    }

    @Override
    public List<Player> findByConditions(List<Predicate<Player>> conditions) {
        if (!loaded) load();
        return players.stream()
                .filter(player -> conditions.stream()
                        .allMatch(condition -> condition.test(player)))
                .collect(Collectors.toList());
    }

    private void writeFile() {
        Path path = Paths.get(FILENAME);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Player player: players) {
                writer.write(player.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}