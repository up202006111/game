package com.LDTS22_23.FB_WG.viewer.game;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.game.elements.Lever;

public class LeverViewer implements ElementViewer<Lever> {
    @Override
    public void draw(Lever lever, GUI gui) {gui.drawLever(lever.getPosition(), lever.getPressed());}
}
