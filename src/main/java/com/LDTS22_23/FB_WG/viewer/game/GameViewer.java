package com.LDTS22_23.FB_WG.viewer.game;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.game.elements.Element;
import com.LDTS22_23.FB_WG.model.game.level.Level;
import com.LDTS22_23.FB_WG.viewer.Viewer;
import java.util.List;

public class GameViewer extends Viewer<Level> {
    public GameViewer(Level menu) {super(menu);}
    @Override
    public void drawElements(GUI gui) {
        gui.drawBackground();
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getPools(), new PoolViewer());
        drawElements(gui, getModel().getLevers(), new LeverViewer());
        drawElements(gui, getModel().getElevators(), new ElevatorViewer());
        drawElements(gui, getModel().getDiamonds(), new DiamondViewer());
        drawElements(gui, getModel().getBoxes(), new BoxViewer());
        drawElements(gui, getModel().getDoors(), new DoorViewer());
        drawElement(gui, getModel().getFireBoy(), new FireBoyViewer());
        drawElement(gui, getModel().getWaterGirl(), new WaterGirlViewer());
    }
    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }
    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
