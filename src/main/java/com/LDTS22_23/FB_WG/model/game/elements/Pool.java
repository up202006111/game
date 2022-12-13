package com.LDTS22_23.FB_WG.model.game.elements;

public class Pool extends Element {
    // Type = 0 means the pool is acid and kills both characters. Write with the character A in the Level1.txt file
    // Type = 1 means the pool is Lava and kills WaterGirl. Write with the character L in the Level1.txt file
    // Type = 2 means the pool is a lake and kills FireBoy. Write with the character l in the Level1.txt file
    private final int Type;
    public Pool(int x, int y, int Type) {super(x, y); this.Type = Type;}
    public int getType() {return Type;}
}
