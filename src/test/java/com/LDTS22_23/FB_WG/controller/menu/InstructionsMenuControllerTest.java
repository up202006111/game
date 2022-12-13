package com.LDTS22_23.FB_WG.controller.menu;

import com.LDTS22_23.FB_WG.Game;
import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.menu.InstructionsMenu;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class InstructionsMenuControllerTest {
    @Test
    void InstructionsMenuTest() throws IOException {
        Game game = Mockito.mock(Game.class);
        InstructionsMenu instructionsMenu = new InstructionsMenu();
        InstructionsMenuController instructionsMenuController = new InstructionsMenuController(instructionsMenu);
        instructionsMenuController.step(game, GUI.ACTION.DOWN_F, 100);
        instructionsMenuController.step(game, GUI.ACTION.UP_F, 100);
        instructionsMenu.previousEntry();
        instructionsMenuController.step(game, GUI.ACTION.SELECT, 100);
    }
}
