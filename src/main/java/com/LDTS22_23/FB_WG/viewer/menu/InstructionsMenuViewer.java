package com.LDTS22_23.FB_WG.viewer.menu;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.Position;
import com.LDTS22_23.FB_WG.model.menu.InstructionsMenu;
import com.LDTS22_23.FB_WG.viewer.Viewer;

public class InstructionsMenuViewer extends Viewer<InstructionsMenu> {
    public InstructionsMenuViewer(InstructionsMenu instructionsMenu) {super(instructionsMenu);}
    @Override
    protected void drawElements(GUI gui) {
        gui.drawBackground();
        gui.drawYinYang(getModel().getRed(), getModel().getBlue());
        gui.drawBorder(getModel().getBorder());

        gui.drawText(new Position(9, 5), getModel().getEntry(0), getModel().isSelectedWandF() ? "#FFD700" : "#FFFFFF");
        gui.drawText(new Position(16, 6), getModel().getEntry(1), getModel().isSelectedPools() ? "#FFD700" : "#FFFFFF");
        gui.drawText(new Position(15, 7), getModel().getEntry(2), getModel().isSelectedDiamonds() ? "#FFD700" : "#FFFFFF");
        gui.drawText(new Position(16, 8), getModel().getEntry(3), getModel().isSelectedDoors() ? "#FFD700" : "#FFFFFF");
        gui.drawText(new Position(5, 9), getModel().getEntry(4), getModel().isSelectedB_E_L() ? "#FFD700" : "#FFFFFF");
        gui.drawText(new Position(16, 10), getModel().getEntry(5), getModel().isSelectedBoxes() ? "#FFD700" : "#FFFFFF");
        gui.drawText(new Position(5, 37), getModel().getEntry(6), getModel().isSelectedGoBack() ? "#FFD700" : "#FFFFFF");

switch (getModel().getCurrentEntry()) {
            case 0: {
                gui.drawText(new Position(2, 30), "These are the controlable characthers", "#FFFFFF");
                gui.drawText(new Position(3, 31), "Your goal is to lead them into the", "#FFFFFF");
                gui.drawText(new Position(11, 32), "end of each level", "#FFFFFF");
                gui.drawText(new Position(3, 33), "WASD to control Watergirl and the", "#FFFFFF");
                gui.drawText(new Position(6, 34), "arrow keys control Fireboy", "#FFFFFF");
            }
            case 1: {
                gui.drawText(new Position(2, 30), "Pools are an elemental adversity for", "#FFFFFF");
                gui.drawText(new Position(2, 31), "the characters. The lava pool kills", "#FFFFFF");
                gui.drawText(new Position(4, 32), "Watergirl, the water pool kills", "#FFFFFF");
                gui.drawText(new Position(2, 33), "Fireboy and the acid pool kills both", "#FFFFFF");
            }
            case 2: {
                gui.drawText(new Position(3, 30), "The diamonds are the collectibles", "#FFFFFF");
                gui.drawText(new Position(2, 31), "of each level. Only Watergirl can get", "#FFFFFF");
                gui.drawText(new Position(2, 32), "the blue ones while the red ones are", "#FFFFFF");
                gui.drawText(new Position(14, 33), "for Fireboy", "#FFFFFF");
            }
            case 3: {
                gui.drawText(new Position(2, 30), "The doors are the exit of each level", "#FFFFFF");
                gui.drawText(new Position(2, 31), "Only Fireboy can go through the red", "#FFFFFF");
                gui.drawText(new Position(5, 32), "door and only Watergirl can go", "#FFFFFF");
                gui.drawText(new Position(9, 33), "through the blue door", "#FFFFFF");
            }
            case 4: {
                gui.drawText(new Position(3, 30), "Elevators are movable platforms in", "#FFFFFF");
                gui.drawText(new Position(2, 31), "each level. They are activated either", "#FFFFFF");
                gui.drawText(new Position(3, 32), "by switching a lever or pressing a", "#FFFFFF");
                gui.drawText(new Position(2, 33), "button. In the case of a button, it", "#FFFFFF");
                gui.drawText(new Position(9, 34), "needs to stay pressed", "#FFFFFF");
            }
            case 5: {
                gui.drawText(new Position(3, 30), "These are both an obstacle in the", "#FFFFFF");
                gui.drawText(new Position(5, 31), "characthers path and a jumping", "#FFFFFF");
                gui.drawText(new Position(3, 32), "platform to help them reach higher", "#FFFFFF");
            }
            default: {}
        }
    }
}
