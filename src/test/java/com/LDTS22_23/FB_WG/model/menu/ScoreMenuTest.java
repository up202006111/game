package com.LDTS22_23.FB_WG.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoreMenuTest {
    private ScoreMenu scoreMenu;
    @BeforeEach
    void setUp() {
        scoreMenu = new ScoreMenu();
    }
    @Test
    void isSelectedNextLevel() {
        scoreMenu.isSelectedNextLevel();
        assert (scoreMenu.getCurrentEntry() != 2);
    }
    @Test
    void isSelectedRetry() {
        scoreMenu.isSelectedRetry();
        assert (scoreMenu.getCurrentEntry() != 1);
    }
    @Test
    void isSelectedGoBack() {
        scoreMenu.isSelectedGoBack();
        assert (scoreMenu.getCurrentEntry() == 0);
    }
}
