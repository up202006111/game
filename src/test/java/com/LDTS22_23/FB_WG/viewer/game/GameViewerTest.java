package com.LDTS22_23.FB_WG.viewer.game;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.Position;
import com.LDTS22_23.FB_WG.model.game.elements.*;
import com.LDTS22_23.FB_WG.model.game.level.Level;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.Arrays;
import static org.mockito.ArgumentMatchers.eq;

public class GameViewerTest {
    private static GUI gui;
    @BeforeAll
    static void setUp() throws IOException {
        Level level = new Level();
        gui = Mockito.mock(GUI.class);
        GameViewer gameViewer = new GameViewer(level);
        level.setWalls(Arrays.asList(new Wall(1, 2), new Wall(2, 3), new Wall(3, 4)));
        level.setDiamonds(Arrays.asList(new Diamond(4, 5, 0), new Diamond(5, 6, 1)));
        level.setDoors(Arrays.asList(new Door(5, 4, 0), new Door(6, 5, 1)));
        level.setLevers(Arrays.asList(new Lever(5, 5, 0, 0), new Lever(6, 6, 0, 1)));
        level.setBoxes(Arrays.asList(new Box(6,7, 0, 1), new Box(7, 6, 1, 1)));
        level.setElevators(Arrays.asList(new Elevator(8, 9, 9, 0), new Elevator(9, 8, 8, 0)));
        level.setPools(Arrays.asList(new Pool(9, 10, 0), new Pool(10,9, 1), new Pool(10, 10, 2)));
        level.setFireBoy(new FireBoy(5, 5));
        level.setWaterGirl(new WaterGirl(7, 7));
        gameViewer.draw(gui);
    }
    @Test
    void drawWalls()  {
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(1, 2));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(2, 3));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(3, 4));
        Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));
    }
    @Test
    void drawDiamonds() {
        Mockito.verify(gui, Mockito.times(1)).drawDiamond(new Position(4, 5), 0);
        Mockito.verify(gui, Mockito.times(1)).drawDiamond(Mockito.any(Position.class), eq(0));
        Mockito.verify(gui, Mockito.times(1)).drawDiamond(new Position(5, 6), 1);
        Mockito.verify(gui, Mockito.times(1)).drawDiamond(Mockito.any(Position.class), eq(1));
    }
    @Test
    void drawDoors0() {
        Mockito.verify(gui, Mockito.times(1)).drawDoor(new Position(5, 4), 0);
        Mockito.verify(gui, Mockito.times(1)).drawDoor(Mockito.any(Position.class), eq(0));
        Mockito.verify(gui, Mockito.times(1)).drawDoor(new Position(6, 5), 1);
        Mockito.verify(gui, Mockito.times(1)).drawDoor(Mockito.any(Position.class), eq(1));
    }
    @Test
    void drawLevers() {
        Mockito.verify(gui, Mockito.times(1)).drawLever(new Position(5, 5), 0);
        Mockito.verify(gui, Mockito.times(1)).drawLever(Mockito.any(Position.class), eq(0));
        Mockito.verify(gui, Mockito.times(1)).drawLever(new Position(6, 6), 1);
        Mockito.verify(gui, Mockito.times(1)).drawLever(Mockito.any(Position.class), eq(1));
    }
    @Test
    void drawBoxes() {
        Mockito.verify(gui, Mockito.times(1)).drawBox(new Position(6, 7));
        Mockito.verify(gui, Mockito.times(1)).drawBox(new Position(7, 6));
        Mockito.verify(gui, Mockito.times(2)).drawBox(Mockito.any(Position.class));
    }
    @Test
    void drawElevators() {
        Mockito.verify(gui, Mockito.times(1)).drawElevator(new Position(8, 9));
        Mockito.verify(gui, Mockito.times(1)).drawElevator(new Position(9, 8));
        Mockito.verify(gui, Mockito.times(2)).drawElevator(Mockito.any(Position.class));
    }
    @Test
    void drawPools() {
        Mockito.verify(gui, Mockito.times(1)).drawPool(new Position(9, 10), 0);
        Mockito.verify(gui, Mockito.times(1)).drawPool(Mockito.any(Position.class), eq(0));
        Mockito.verify(gui, Mockito.times(1)).drawPool(new Position(10, 9), 1);
        Mockito.verify(gui, Mockito.times(1)).drawPool(Mockito.any(Position.class), eq(1));
        Mockito.verify(gui, Mockito.times(1)).drawPool(new Position(10, 10), 2);
        Mockito.verify(gui, Mockito.times(1)).drawPool(Mockito.any(Position.class), eq(2));
    }
    @Test
    void drawFireBoy() {
        Mockito.verify(gui, Mockito.times(1)).drawFireBoy(new Position(5, 5));
        Mockito.verify(gui, Mockito.times(1)).drawFireBoy(Mockito.any(Position.class));
    }
    @Test
    void drawWaterGirl() {
        Mockito.verify(gui, Mockito.times(1)).drawWaterGirl(new Position(7, 7));
        Mockito.verify(gui, Mockito.times(1)).drawWaterGirl(Mockito.any(Position.class));
    }
    @Test
    void refreshAndClear() throws IOException {
        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}