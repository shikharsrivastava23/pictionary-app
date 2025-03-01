package com.shikhar.pictionary.model;

import java.util.List;
import java.util.ArrayList;

public class Room {
    private String roomCode;
    private List<Player> players = new ArrayList<>();

    public Room(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
