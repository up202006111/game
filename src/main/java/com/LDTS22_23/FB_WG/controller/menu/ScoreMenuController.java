package com.LDTS22_23.FB_WG.controller.menu;

import com.LDTS22_23.FB_WG.Game;
import com.LDTS22_23.FB_WG.controller.Controller;
import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.game.level.LoaderLevelBuilder;
import com.LDTS22_23.FB_WG.model.menu.LoaderMenuBuilder;
import com.LDTS22_23.FB_WG.model.menu.ScoreMenu;
import com.LDTS22_23.FB_WG.states.GameState;
import com.LDTS22_23.FB_WG.states.LevelMenuState;
import java.io.IOException;

public class ScoreMenuController extends Controller<ScoreMenu> {
    public ScoreMenuController(ScoreMenu scoreMenu) {super(scoreMenu);}
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP_F, LEFT_F, UP_W, LEFT_W -> getModel().previousEntry();
            case DOWN_F, RIGHT_F, DOWN_W, RIGHT_W -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedGoBack()) {
                    game.setState(new LevelMenuState(new LoaderMenuBuilder().createLevelMenu()));
                }
                if (getModel().isSelectedRetry()) {
                    game.setState(new GameState(new LoaderLevelBuilder(game.getLevelNumber()).createLevel()));
                }
                if (getModel().isSelectedNextLevel()) {
                    game.setLevelNumber(game.getLevelNumber() + 1);
                    if (game.getLevelNumber() >= 3) {
                        game.setState(new LevelMenuState(new LoaderMenuBuilder().createLevelMenu()));
                    }
                    else {
                        game.setState(new GameState(new LoaderLevelBuilder(game.getLevelNumber()).createLevel()));
                    }
                }
            }
        }
    }
}