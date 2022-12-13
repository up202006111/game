package com.LDTS22_23.FB_WG.controller.menu;

import com.LDTS22_23.FB_WG.Game;
import com.LDTS22_23.FB_WG.controller.Controller;
import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.menu.InstructionsMenu;
import com.LDTS22_23.FB_WG.model.menu.LoaderMenuBuilder;
import com.LDTS22_23.FB_WG.states.GameMenuState;
import java.io.IOException;

public class InstructionsMenuController extends Controller<InstructionsMenu> {
    public InstructionsMenuController(InstructionsMenu instructionsMenu) {super(instructionsMenu);}
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP_F, LEFT_F, UP_W, LEFT_W -> getModel().previousEntry();
            case DOWN_F, RIGHT_F,DOWN_W, RIGHT_W -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedGoBack()) {
                    game.setState(new GameMenuState(new LoaderMenuBuilder().createGameMenu()));
                }
            }
        }
    }
}
