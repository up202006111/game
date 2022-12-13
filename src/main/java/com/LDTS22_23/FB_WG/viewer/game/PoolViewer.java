package com.LDTS22_23.FB_WG.viewer.game;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.game.elements.Pool;

public class PoolViewer implements ElementViewer<Pool>{
    @Override
    public void draw(Pool pool, GUI gui) {gui.drawPool(pool.getPosition(), pool.getType());}
}
