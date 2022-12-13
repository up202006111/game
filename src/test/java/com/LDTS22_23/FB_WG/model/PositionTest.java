package com.LDTS22_23.FB_WG.model;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    @Property
    void getLeft(@ForAll int x, @ForAll int y) {
        assertEquals(x - 1, new Position(x, y).moveLeft().get_x());
        assertEquals(y, new Position(x, y).moveLeft().get_y());
    }
    @Property
    void getRight(@ForAll int x, @ForAll int y) {
        assertEquals(x + 1, new Position(x, y).moveRight().get_x());
        assertEquals(y, new Position(x, y).moveRight().get_y());
    }
    @Property
    void getUp(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).moveUp().get_x());
        assertEquals(y - 1, new Position(x, y).moveUp().get_y());
    }
    @Property
    void getDown(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).moveDown().get_x());
        assertEquals(y + 1, new Position(x, y).moveDown().get_y());
    }
}