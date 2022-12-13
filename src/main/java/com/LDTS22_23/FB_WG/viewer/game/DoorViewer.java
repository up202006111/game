package com.LDTS22_23.FB_WG.viewer.game;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.game.elements.Door;

public class DoorViewer implements ElementViewer<Door> {
    @Override
    public void draw(Door door, GUI gui) {gui.drawDoor(door.getPosition(), door.getType());}
}
