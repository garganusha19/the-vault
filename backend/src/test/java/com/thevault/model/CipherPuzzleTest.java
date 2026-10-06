package com.thevault.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CipherPuzzleTest {

    @Test
    void shouldCreateCipherPuzzleCorrectly() {

        CipherPuzzle puzzle = new CipherPuzzle(
                1,
                "Decode KHOOR",
                "HELLO",
                Difficulty.MEDIUM,
                3
        );

        assertEquals(1, puzzle.getId());
        assertEquals("Decode KHOOR", puzzle.getQuestion());
        assertEquals("HELLO", puzzle.getAnswer());
        assertEquals(Difficulty.MEDIUM, puzzle.getDifficulty());
        assertTrue(puzzle.isLocked());
    }

    @Test
void shouldDecodeCaesarCipher() {

    CipherPuzzle puzzle = new CipherPuzzle(
            1,
            "KHOOR",
            "HELLO",
            Difficulty.MEDIUM,
            3
    );

    String decoded = puzzle.decode("KHOOR");

    assertEquals("HELLO", decoded);
    assertEquals("XYZ", puzzle.decode("ABC"));
    assertEquals(3, puzzle.getShift());
}
}