package com.fm.repository;

import com.fm.game.SearchCondition;
import com.fm.unit.Player;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlayerSearchPredicateFactory {
    public static List<Predicate<Player>> makeConditions(List<SearchCondition> searchConditions) {
        return searchConditions.stream()
                .map(condition -> {
                    String field = condition.getField();
                    String value = condition.getCondition().toLowerCase();

                    Predicate<Player> predicate;
                    switch (field) {
                        case "club":
                            predicate = (Player player) -> player.getClub()
                                    .toLowerCase()
                                    .contains(value);
                            break;
                        case "nationality":
                            predicate = (Player player) -> player.getNationality()
                                    .toLowerCase()
                                    .contains(value);
                            break;
                        case "name":
                            predicate = (Player player) -> player.getName()
                                    .toLowerCase()
                                    .contains(value);
                            break;
                        case "position":
                            predicate = (Player player) -> player.getPositions()
                                    .stream()
                                    .anyMatch(pos -> pos.toLowerCase()
                                            .equals(value));
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown field: " + field);
                    }
                    return predicate;
                })
                .collect(Collectors.toList());
    }
}