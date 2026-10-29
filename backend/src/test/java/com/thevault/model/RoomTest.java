package com.thevault.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomTest {

    @Test
    void shouldCreateRoomCorrectly() {

        Room room = new Room(1, "Entrance");

        assertEquals(1, room.getId());
        assertEquals("Entrance", room.getName());
    }
}