package com.LDTS22_23.FB_WG.controller.game;

import com.LDTS22_23.FB_WG.Game;
import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.game.level.Level;
import com.LDTS22_23.FB_WG.model.menu.LoaderMenuBuilder;
import com.LDTS22_23.FB_WG.states.ScoreMenuState;
import java.io.IOException;

public class LevelController extends GameController {
    private final CharacterController characterController;
    public LevelController(Level level) {
        super(level);
        characterController = new CharacterController(level);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) {
            game.setState(new ScoreMenuState(new LoaderMenuBuilder().createScoreMenu(0, getModel().getFireBoy().getRedDiamonds(), getModel().getWaterGirl().getBlueDiamonds())));
        }
        else if (getModel().fallInTheAcidPool(getModel().getWaterGirl().getPosition()) || getModel().fallInTheAcidPool(getModel().getFireBoy().getPosition()) ||
                getModel().fallInTheLavaPool(getModel().getWaterGirl().getPosition()) || getModel().fallInTheWaterPool(getModel().getFireBoy().getPosition())) {
            game.setState(new ScoreMenuState(new LoaderMenuBuilder().createScoreMenu(0, getModel().getFireBoy().getRedDiamonds(), getModel().getWaterGirl().getBlueDiamonds())));
        }
        else if (getModel().enterBlueDoor(getModel().getWaterGirl().getPosition()) && getModel().enterRedDoor(getModel().getFireBoy().getPosition())) {
            game.setState(new ScoreMenuState(new LoaderMenuBuilder().createScoreMenu(1, getModel().getFireBoy().getRedDiamonds(), getModel().getWaterGirl().getBlueDiamonds())));
        }
        else {
            characterController.step(game, action, time);
        }
    }
}
