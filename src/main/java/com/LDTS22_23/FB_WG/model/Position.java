package com.LDTS22_23.FB_WG.model;

public class Position {
    private final int x_;
    private final int y_;
    public Position(int x, int y) {x_ = x; y_ = y;}
    public int get_x() {return x_;}
    public int get_y() {return y_;}
    public Position moveLeft() {return new Position(x_ - 1, y_);}
    public Position moveRight() {return new Position(x_ + 1, y_);}
    public Position moveUp() {return new Position(x_, y_ - 1);}
    public Position moveDown() {return new Position(x_, y_ + 1);}
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return x_ == p.get_x() && y_ == p.get_y();
    }
}
