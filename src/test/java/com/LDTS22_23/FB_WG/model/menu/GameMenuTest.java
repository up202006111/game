package com.LDTS22_23.FB_WG.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameMenuTest {
    private GameMenu gameMenu;
    @BeforeEach
    void setUp() {gameMenu = new GameMenu();}
    @Test
    void isSelectedExit() {
        gameMenu.isSelectedExit();
        assert (gameMenu.getCurrentEntry() != 2);
    }
    @Test
    void isSelectedInstructions() {
        gameMenu.isSelectedInstructions();
        assert (gameMenu.getCurrentEntry() != 1);
    }
    @Test
    void isSelectedStart() {
        gameMenu.isSelectedStart();
        assert (gameMenu.getCurrentEntry() == 0);
    }
    @Test
    void nextEntry() {
        gameMenu.nextEntry();
        assert (gameMenu.getCurrentEntry() == 1);
        gameMenu.nextEntry();
        assert (gameMenu.getCurrentEntry() == 2);
        gameMenu.nextEntry();
        assert (gameMenu.getCurrentEntry() == 0);
    }
    @Test
    void previousEntry() {
        gameMenu.previousEntry();
        assert (gameMenu.getCurrentEntry() == 2);
        gameMenu.previousEntry();
        assert (gameMenu.getCurrentEntry() == 1);
        gameMenu.previousEntry();
        assert (gameMenu.getCurrentEntry() == 0);
    }
}
