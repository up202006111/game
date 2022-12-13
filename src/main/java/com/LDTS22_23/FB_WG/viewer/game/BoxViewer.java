package com.LDTS22_23.FB_WG.viewer.game;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.game.elements.Box;

public class BoxViewer implements ElementViewer<Box> {
    @Override
    public void draw(Box box, GUI gui) {gui.drawBox(box.getPosition());}
}
