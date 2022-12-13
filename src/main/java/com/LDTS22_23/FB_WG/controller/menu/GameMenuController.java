package com.LDTS22_23.FB_WG.controller.menu;

import com.LDTS22_23.FB_WG.Game;
import com.LDTS22_23.FB_WG.controller.Controller;
import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.menu.GameMenu;
import com.LDTS22_23.FB_WG.model.menu.InstructionsMenu;
import com.LDTS22_23.FB_WG.model.menu.LoaderMenuBuilder;
import com.LDTS22_23.FB_WG.states.InstructionsMenuState;
import com.LDTS22_23.FB_WG.states.LevelMenuState;
import java.io.IOException;

public class GameMenuController extends Controller<GameMenu> {
    public GameMenuController(GameMenu gameMenu) {super(gameMenu);}
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP_F, UP_W -> getModel().previousEntry();
            case DOWN_F, DOWN_W -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedExit()) {
                    game.setState(null);
                }
                if (getModel().isSelectedInstructions()) {
                    game.setState(new InstructionsMenuState(new LoaderMenuBuilder().createInstructionsMenu()));
                }
                if (getModel().isSelectedStart()) {
                    game.setState(new LevelMenuState(new LoaderMenuBuilder().createLevelMenu()));
                }
            }
        }
    }
}
