package com.LDTS22_23.FB_WG.viewer.menu;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.Position;
import com.LDTS22_23.FB_WG.model.menu.GameMenu;
import com.LDTS22_23.FB_WG.viewer.Viewer;

public class GameMenuViewer extends Viewer<GameMenu> {
    public GameMenuViewer(GameMenu gameMenu) {super(gameMenu);}
    @Override
    public void drawElements(GUI gui) {
        gui.drawBackground();
        gui.drawYinYang(getModel().getRed(), getModel().getBlue());
        gui.drawBorder(getModel().getBorder());

        gui.drawText(new Position(9, 7), "FireBoy", "#d01e1e");
        gui.drawText(new Position(17, 7), "and", "#FFFFFF");
        gui.drawText(new Position(21, 7), "WaterGirl", "#3d87d1");
        gui.drawText(new Position(8, 8), "Into the Lanterna Temple", "#FFFFFF");

        gui.drawText(new Position(17, 31), getModel().getEntry(0), getModel().isSelectedStart() ? "#FFD700" : "#FFFFFF");
        gui.drawText(new Position(14, 32), getModel().getEntry(1), getModel().isSelectedInstructions() ? "#FFD700" : "#FFFFFF");
        gui.drawText(new Position(17, 33), getModel().getEntry(2), getModel().isSelectedExit() ? "#FFD700" : "#FFFFFF");
    }
}
