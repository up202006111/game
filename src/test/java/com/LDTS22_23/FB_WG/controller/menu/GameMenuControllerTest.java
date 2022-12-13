package com.LDTS22_23.FB_WG.controller.menu;

import com.LDTS22_23.FB_WG.Game;
import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.menu.GameMenu;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class GameMenuControllerTest {
    @Test
    void setUp() throws IOException {
        Game game = Mockito.mock(Game.class);
        GameMenu gameMenu = new GameMenu();
        GameMenuController gameMenuController= new GameMenuController(gameMenu);
        gameMenuController.step(game, GUI.ACTION.UP_W, 100);
        gameMenuController.step(game, GUI.ACTION.DOWN_W, 100);
        gameMenuController.step(game, GUI.ACTION.SELECT, 100);
        gameMenu.nextEntry();
        gameMenuController.step(game, GUI.ACTION.SELECT, 100);
        gameMenu.nextEntry();
        gameMenuController.step(game, GUI.ACTION.SELECT, 100);
    }
}
