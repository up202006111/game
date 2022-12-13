package com.LDTS22_23.FB_WG.viewer.menu;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.Position;
import com.LDTS22_23.FB_WG.model.menu.GameMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.List;

public class GameMenuViewerTest {
    private GUI gui;
    private GameMenuViewer gameMenuViewer;
    @BeforeEach
    void setUp() {
        GameMenu gameMenu = new GameMenu();
        gui = Mockito.mock(GUI.class);
        gameMenuViewer = new GameMenuViewer(gameMenu);
        gameMenu.setRed(List.of(new Position(1, 1)));
        gameMenu.setBlue(List.of(new Position(2, 2)));
        gameMenu.setBorder(List.of(new Position(0, 0)));
    }
    @Test
    void drawYinYang() throws IOException {
        gameMenuViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawYinYang(List.of(new Position(1, 1)), List.of(new Position(2, 2)));
        Mockito.verify(gui, Mockito.times(1)).drawYinYang(Mockito.any(), Mockito.any());
    }
    @Test
    void drawBorder() throws IOException {
        gameMenuViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawBorder(List.of(new Position(0, 0)));
        Mockito.verify(gui, Mockito.times(1)).drawBorder(Mockito.any());
    }
}
