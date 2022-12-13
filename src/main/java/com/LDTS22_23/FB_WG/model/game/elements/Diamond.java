package com.LDTS22_23.FB_WG.model.game.elements;

public class Diamond extends Element {
    private final int Type;
    // Type = 0 means the diamond is red and belongs to FireBoy. Write with the character D in the Level1.txt file
    // Type = 1 means the diamond is blue and belongs to WaterGirl. Write with the character d in the Level1.txt file
    public Diamond(int x, int y, int Type) {super(x, y); this.Type = Type;}
    public int getType() {return Type;}
}
