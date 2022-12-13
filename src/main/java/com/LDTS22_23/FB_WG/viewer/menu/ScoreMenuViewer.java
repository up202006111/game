package com.LDTS22_23.FB_WG.viewer.menu;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.Position;
import com.LDTS22_23.FB_WG.model.menu.ScoreMenu;
import com.LDTS22_23.FB_WG.viewer.Viewer;

public class ScoreMenuViewer extends Viewer<ScoreMenu> {
    public ScoreMenuViewer(ScoreMenu scoreMenu) {super(scoreMenu);}
    @Override
    protected void drawElements(GUI gui) {
        gui.drawBackground();
        gui.drawYinYang(getModel().getRed(), getModel().getBlue());
        gui.drawBorder(getModel().getBorder());

        gui.drawText(new Position(17, 5), "Score:", "#FFFFFF");
        gui.drawText(new Position(5, 8), "Red Diamonds: ", "#FFFFFF");
        gui.drawText(new Position(24, 8), "" + getModel().getRedDiamonds(), "#FFFFFF");
        gui.drawText(new Position(5, 10), "Blue Diamonds: ", "#FFFFFF");
        gui.drawText(new Position(24, 10), "" + getModel().getBlueDiamonds(), "#FFFFFF");
        if (getModel().getScore() == 0) {
            gui.drawText(new Position(3, 17), "You", "#FFFFFF");
            gui.drawText(new Position(3, 19), "Lost", "#FFFFFF");
        } else {
            gui.drawText(new Position(30, 17), "You", "#FFFFFF");
            gui.drawText(new Position(30, 19), "Won", "#FFFFFF");
        }
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(14, 30 + 2 * i), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
