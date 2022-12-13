package com.LDTS22_23.FB_WG.viewer.game;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.game.elements.Diamond;

public class DiamondViewer implements ElementViewer<Diamond> {
    @Override
    public void draw(Diamond diamond, GUI gui) {gui.drawDiamond(diamond.getPosition(), diamond.getType());}
}
