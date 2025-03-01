package com.shikhar.pictionary.service;

import org.springframework.stereotype.Service;

import com.shikhar.pictionary.model.Player;
import com.shikhar.pictionary.model.Room;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class RoomService {

    // In-memory storage for rooms
    private Map<String, Room> roomMap = new HashMap<>();

    public Room createRoom(Player admin) {
        String roomCode = generateRoomCode();
        Room room = new Room(roomCode);
        room.addPlayer(admin);
        roomMap.put(roomCode, room);
        return room;
    }

    public Room joinRoom(String roomCode, Player player) {
        Room room = roomMap.get(roomCode);
        if (room != null && room.getPlayers().size() < 8) {
            room.addPlayer(player);
            return room;
        }
        return null;
    }

    // Generate a simple 6-character alphanumeric room code
    private String generateRoomCode() {
        return UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }
}
