package com.LDTS22_23.FB_WG.controller.game;

import com.LDTS22_23.FB_WG.Game;
import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.Position;
import com.LDTS22_23.FB_WG.model.game.level.Level;

public class CharacterController extends GameController {
    private long lastTime;
    public CharacterController(Level level) {super(level); lastTime = 0;}
    public void moveFireBoyUp() {moveFireBoy(getModel().getFireBoy().getPosition().moveUp());}
    public void moveFireBoyDown() {moveFireBoy(getModel().getFireBoy().getPosition().moveDown());}
    public void moveFireBoyLeft() {moveFireBoy(getModel().getFireBoy().getPosition().moveLeft());}
    public void moveFireBoyRight() {moveFireBoy(getModel().getFireBoy().getPosition().moveRight());}
    public void moveWaterGirlUp() {moveWaterGirl(getModel().getWaterGirl().getPosition().moveUp());}
    public void moveWaterGirlDown() {moveWaterGirl(getModel().getWaterGirl().getPosition().moveDown());}
    public void moveWaterGirlLeft() {moveWaterGirl(getModel().getWaterGirl().getPosition().moveLeft());}
    public void moveWaterGirlRight() {moveWaterGirl(getModel().getWaterGirl().getPosition().moveRight());}
    public void moveFireBoy(Position position) {
        if (getModel().canCharacterMove(position)) {
            getModel().getFireBoy().setPosition(position);
            getModel().retrieveFire(position);
            getModel().leverCallElevator(position);
        }
    }
    public void moveWaterGirl(Position position) {
        if (getModel().canCharacterMove(position)) {
            getModel().getWaterGirl().setPosition(position);
            getModel().retrieveWater(position);
            getModel().leverCallElevator(position);
        }
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (time - lastTime > 600) {
            getModel().gravityForBoxes();
            moveWaterGirlDown();
            moveFireBoyDown();
            lastTime = time;
        }
        switch (action) {
            case UP_F -> {
                moveFireBoyUp();
                moveFireBoyUp();
            }
            case LEFT_F -> moveFireBoyLeft();
            case RIGHT_F -> moveFireBoyRight();
            case UP_W -> {
                moveWaterGirlUp();
                moveWaterGirlUp();
            }
            case LEFT_W -> moveWaterGirlLeft();
            case RIGHT_W -> moveWaterGirlRight();
        }
    }
}
