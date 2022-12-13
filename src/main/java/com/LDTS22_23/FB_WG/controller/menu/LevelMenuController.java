package com.LDTS22_23.FB_WG.controller.menu;

import com.LDTS22_23.FB_WG.Game;
import com.LDTS22_23.FB_WG.controller.Controller;
import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.game.level.LoaderLevelBuilder;
import com.LDTS22_23.FB_WG.model.menu.LevelMenu;
import com.LDTS22_23.FB_WG.model.menu.LoaderMenuBuilder;
import com.LDTS22_23.FB_WG.states.GameMenuState;
import com.LDTS22_23.FB_WG.states.GameState;
import java.io.IOException;

public class LevelMenuController extends Controller<LevelMenu> {
    public LevelMenuController(LevelMenu levelMenu) {super(levelMenu);}
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case DOWN_F, LEFT_F, DOWN_W, LEFT_W -> getModel().previousEntry();
            case UP_F, RIGHT_F, UP_W, RIGHT_W -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelected(getModel().getNumberEntries() - 1)) {
                    game.setState(new GameMenuState(new LoaderMenuBuilder().createGameMenu()));
                }
                for (int i = 0; i < getModel().getNumberEntries() - 1; i++) {
                    if (getModel().isSelected(i)) {
                        game.setState(new GameState(new LoaderLevelBuilder(i + 1).createLevel()));
                        game.setLevelNumber(i + 1);
                    }
                }
            }
        }
    }
}
