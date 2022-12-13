package com.LDTS22_23.FB_WG.viewer.menu;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.Position;
import com.LDTS22_23.FB_WG.model.menu.LevelMenu;
import com.LDTS22_23.FB_WG.viewer.Viewer;

public class LevelMenuViewer extends Viewer<LevelMenu> {
    public LevelMenuViewer(LevelMenu levelMenu) {super(levelMenu);}
    @Override
    public void drawElements(GUI gui) {
        gui.drawBackground();
        gui.drawYinYang(getModel().getRed(), getModel().getBlue());
        gui.drawBorder(getModel().getBorder());

        gui.drawText(new Position(16, 7), "Levels", "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries() - 1; i++) {
            gui.drawText(new Position(13 + 5 * i, 20), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
        gui.drawText(new Position(5 , 35), getModel().getEntry(getModel().getNumberEntries() - 1), getModel().isSelected(getModel().getNumberEntries() - 1) ? "#FFD700" : "#FFFFFF");
    }
}
