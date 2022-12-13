package com.LDTS22_23.FB_WG.viewer.game;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.game.elements.WaterGirl;

public class WaterGirlViewer implements ElementViewer<WaterGirl> {
    @Override
    public void draw(WaterGirl waterGirl, GUI gui) {gui.drawWaterGirl(waterGirl.getPosition());}
}
