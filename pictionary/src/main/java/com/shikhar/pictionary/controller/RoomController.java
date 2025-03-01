package com.shikhar.pictionary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shikhar.pictionary.model.Player;
import com.shikhar.pictionary.model.Room;
import com.shikhar.pictionary.service.RoomService;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    private RoomService roomService;

    // API to create a room. The creator becomes the admin.
    @PostMapping("/create")
    public Room createRoom(@RequestParam String username) {
        logger.info("Received request to create room by username: {}", username);
        Player admin = new Player(username, true);
        Room room = roomService.createRoom(admin);
        logger.info("Room created with roomCode: {}", room.getRoomCode());
        return room;
    }

    @PostMapping("/join")
    public Room joinRoom(@RequestParam String roomCode, @RequestParam String username) {
        logger.info("Received request to join room {} by username: {}", roomCode, username);
        Player player = new Player(username, false);
        Room room = roomService.joinRoom(roomCode, player);
        if (room != null) {
            logger.info("User {} joined room: {}", username, room.getRoomCode());
        } else {
            logger.warn("Failed to join room. Room {} not found or full. Username: {}", roomCode, username);
        }
        return room;
    }
}
