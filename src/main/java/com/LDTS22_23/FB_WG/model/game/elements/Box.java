package com.LDTS22_23.FB_WG.model.game.elements;

public class Box extends Element {
    //Write with the character O in the Level1.txt file
    //Side = 0 means this is the left side of the box
    //Side = 1 means this is the right side of the box
    //Side = 3 means this is the top of the box
    private final int Number;
    private final int Side;
    public Box(int x, int y, int side, int number) {super(x, y); Side = side; Number = number;}
    public int getNumber() {return Number;}
    public int getSide() {return Side;}
}
