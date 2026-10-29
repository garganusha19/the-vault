package com.thevault.engine;

import com.thevault.model.Room;

public class VaultGame {

    private Room[][] roomGrid;

    public VaultGame(int rows, int columns) {
        roomGrid = new Room[rows][columns];
    }

    public Room[][] getRoomGrid() {
        return roomGrid;
    }

    public void addRoom(int row, int column, Room room) {
        if (row < 0 || row >= roomGrid.length ||
            column < 0 || column >= roomGrid[row].length) {
            throw new IllegalArgumentException("Invalid room position");
        }

        roomGrid[row][column] = room;
    }
}