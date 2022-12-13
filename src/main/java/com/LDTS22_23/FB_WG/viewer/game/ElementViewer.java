package com.LDTS22_23.FB_WG.viewer.game;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
