package com.LDTS22_23.FB_WG.viewer.game;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.game.elements.Elevator;

public class ElevatorViewer implements ElementViewer<Elevator> {
    @Override
    public void draw(Elevator elevator, GUI gui) {gui.drawElevator(elevator.getPosition());}
}
