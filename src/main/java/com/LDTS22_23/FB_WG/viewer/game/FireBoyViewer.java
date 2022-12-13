package com.LDTS22_23.FB_WG.viewer.game;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.game.elements.FireBoy;

public class FireBoyViewer implements ElementViewer<FireBoy> {
    @Override
    public void draw(FireBoy fireBoy, GUI gui) {gui.drawFireBoy(fireBoy.getPosition());}
}
