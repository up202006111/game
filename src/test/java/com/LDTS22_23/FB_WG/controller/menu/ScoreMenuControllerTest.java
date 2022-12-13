package com.LDTS22_23.FB_WG.controller.menu;

import com.LDTS22_23.FB_WG.Game;
import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.menu.ScoreMenu;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class ScoreMenuControllerTest {
    @Test
    void ScoreMenuTest() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        game.setLevelNumber(1);
        ScoreMenu scoreMenu = new ScoreMenu();
        ScoreMenuController scoreMenuController= new ScoreMenuController(scoreMenu);
        scoreMenuController.step(game, GUI.ACTION.UP_W, 100);
        scoreMenuController.step(game, GUI.ACTION.DOWN_W, 100);
        scoreMenuController.step(game, GUI.ACTION.SELECT, 100);
        scoreMenu.nextEntry();
        scoreMenuController.step(game, GUI.ACTION.SELECT, 100);
        scoreMenu.nextEntry();
        scoreMenuController.step(game, GUI.ACTION.SELECT, 100);
        game.setLevelNumber(5);
        scoreMenuController.step(game, GUI.ACTION.SELECT, 100);
    }
}
