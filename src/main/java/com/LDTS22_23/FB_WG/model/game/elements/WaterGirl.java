package com.LDTS22_23.FB_WG.model.game.elements;

public class WaterGirl extends Element {
    //Write with the character W in the Level1.txt file
    private int BlueDiamonds;
    public WaterGirl(int x, int y) {super(x, y);}
    public int getBlueDiamonds() {return BlueDiamonds;}
    public void addBlueDiamonds() {BlueDiamonds++;}
}
