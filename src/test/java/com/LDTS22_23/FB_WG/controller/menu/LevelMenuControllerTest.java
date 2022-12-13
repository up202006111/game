package com.LDTS22_23.FB_WG.controller.menu;

import com.LDTS22_23.FB_WG.Game;
import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.menu.LevelMenu;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class LevelMenuControllerTest {
    @Test
    void LevelMenuTest() throws IOException {
        Game game = Mockito.mock(Game.class);
        LevelMenu levelMenu = new LevelMenu();
        LevelMenuController levelMenuController= new LevelMenuController(levelMenu);
        levelMenuController.step(game, GUI.ACTION.UP_W, 100);
        levelMenuController.step(game, GUI.ACTION.DOWN_W, 100);
        levelMenuController.step(game, GUI.ACTION.SELECT, 100);
        levelMenu.nextEntry();
        levelMenu.nextEntry();
        levelMenu.nextEntry();
        levelMenuController.step(game, GUI.ACTION.SELECT, 100);
    }
}
