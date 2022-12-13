package com.LDTS22_23.FB_WG.model.menu;

import java.util.Arrays;

public class ScoreMenu extends Menu {
    private int Score;
    private int BlueDiamonds;
    private int RedDiamonds;
    public ScoreMenu() {super(Arrays.asList("<- Go Back", "Retry", "Next level ->"));}
    public int getScore() {return Score;}
    public int getRedDiamonds() {return RedDiamonds;}
    public int getBlueDiamonds() {return BlueDiamonds;}
    public void setScore(int score) {Score = score;}
    public void setBlueDiamonds(int blueDiamonds) {BlueDiamonds = blueDiamonds;}
    public void setRedDiamonds(int redDiamonds) {RedDiamonds = redDiamonds;}
    public boolean isSelectedNextLevel() {return isSelected(2);}
    public boolean isSelectedRetry() {return isSelected(1);}
    public boolean isSelectedGoBack() {return isSelected(0);}
}
