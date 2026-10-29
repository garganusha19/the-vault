package com.thevault.engine;

import com.thevault.model.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VaultGameTest {

    @Test
    void shouldInitializeRoomGridCorrectly() {
        VaultGame game = new VaultGame(2, 3);

        assertEquals(2, game.getRoomGrid().length);
        assertEquals(3, game.getRoomGrid()[0].length);
    }

    @Test
    void roomGridShouldInitiallyContainNull() {
        VaultGame game = new VaultGame(2, 3);

        assertNull(game.getRoomGrid()[0][0]);
        assertNull(game.getRoomGrid()[1][2]);
    }

    @Test
    void shouldAddRoomAtCorrectPosition() {
        VaultGame game = new VaultGame(2, 3);
        Room entrance = new Room(1, "Entrance");

        game.addRoom(1, 2, entrance);

        assertSame(entrance, game.getRoomGrid()[1][2]);
        assertNull(game.getRoomGrid()[0][0]);
    }

    @Test
    void shouldRejectInvalidRoomPosition() {
        VaultGame game = new VaultGame(2, 3);
        Room entrance = new Room(1, "Entrance");

        assertThrows(IllegalArgumentException.class, () -> game.addRoom(-1, 0, entrance));
        assertThrows(IllegalArgumentException.class, () -> game.addRoom(2, 0, entrance));
        assertThrows(IllegalArgumentException.class, () -> game.addRoom(0, -1, entrance));
        assertThrows(IllegalArgumentException.class, () -> game.addRoom(0, 3, entrance));
    }
}