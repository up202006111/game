package com.LDTS22_23.FB_WG.model.game.elements;

public class Lever extends Element {
    //Write with the character b in the Level1.txt file
    private final int Number;
    private int Pressed;
    public Lever(int x, int y, int number, int pressed) {super(x, y); Number = number; Pressed = pressed;}
    public int getNumber() {return Number;}
    public int getPressed() {return Pressed;}
    public void onAndOff() {
        Pressed++;
        if (Pressed > 1) Pressed = 0;
    }
}
