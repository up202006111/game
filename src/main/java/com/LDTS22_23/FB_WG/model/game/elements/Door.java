package com.LDTS22_23.FB_WG.model.game.elements;

public class Door extends Element{
    private final int Type;
    // Type = 0 means the door is red and belongs to FireBoy. Write with the character P in the Level1.txt file
    // Type = 1 means the door is blue and belongs to WaterGirl. Write with the character p in the Level1.txt file
    public Door(int x, int y, int Type) {super(x, y); this.Type = Type;}
    public int getType() {return Type;}
}
