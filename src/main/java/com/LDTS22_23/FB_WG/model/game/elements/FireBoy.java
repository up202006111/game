package com.LDTS22_23.FB_WG.model.game.elements;

public class FireBoy extends Element {
    //Write with the character F in the Level1.txt file
    private int RedDiamonds;
    public FireBoy(int x, int y) {super(x, y);}
    public int getRedDiamonds() {return RedDiamonds;}
    public void addRedDiamonds() {RedDiamonds++;}
}
