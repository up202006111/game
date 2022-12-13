package com.LDTS22_23.FB_WG.model.menu;

import com.LDTS22_23.FB_WG.model.Position;
import java.util.List;

public abstract class MenuBuilder {
    public GameMenu createGameMenu() {
        GameMenu gameMenu = new GameMenu();
        gameMenu.setRed(createRed());
        gameMenu.setBlue(createBlue());
        gameMenu.setBorder(createBorder());
        return gameMenu;
    }
    public LevelMenu createLevelMenu() {
        LevelMenu levelmenu = new LevelMenu();
        levelmenu.setBorder(createBorder());
        levelmenu.setRed(createRed());
        levelmenu.setBlue(createBlue());
        return levelmenu;
    }
    public ScoreMenu createScoreMenu(int score, int redDiamonds, int blueDiamonds) {
        ScoreMenu scoreMenu = new ScoreMenu();
        scoreMenu.setScore(score);
        scoreMenu.setRedDiamonds(redDiamonds);
        scoreMenu.setBlueDiamonds(blueDiamonds);
        scoreMenu.setBorder(createBorder());
        scoreMenu.setRed(createRed());
        scoreMenu.setBlue(createBlue());
        return scoreMenu;
    }
    public InstructionsMenu createInstructionsMenu() {
        InstructionsMenu instructionsMenu = new InstructionsMenu();
        instructionsMenu.setBorder(createBorder());
        instructionsMenu.setRed(createRed());
        instructionsMenu.setBlue(createBlue());
        return instructionsMenu;
    }
    protected abstract List<Position> createRed();
    protected abstract List<Position> createBlue();
    protected abstract List<Position> createBorder();
}
