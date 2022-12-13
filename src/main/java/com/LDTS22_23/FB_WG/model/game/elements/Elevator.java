package com.LDTS22_23.FB_WG.model.game.elements;

public class Elevator extends Element {
    //Write with the character E in the Level1.txt file
    private final int Number;
    private final int Initial_y;
    public Elevator(int x, int y, int initial_y ,int number) {super(x, y); Initial_y = initial_y; Number = number;}
    public int getNumber() {return Number;}
    public int getInitial_y() {return Initial_y;}
}
