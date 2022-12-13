package com.LDTS22_23.FB_WG.viewer.menu;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.Position;
import com.LDTS22_23.FB_WG.model.menu.LevelMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.List;

public class LevelMenuViewerTest {
    private GUI gui;
    private LevelMenuViewer levelMenuViewer;
    @BeforeEach
    void setUp() {
        LevelMenu levelMenu = new LevelMenu();
        gui = Mockito.mock(GUI.class);
        levelMenuViewer = new LevelMenuViewer(levelMenu);
        levelMenu.setRed(List.of(new Position(1, 1)));
        levelMenu.setBlue(List.of(new Position(2, 2)));
        levelMenu.setBorder(List.of(new Position(0, 0)));
    }
    @Test
    void drawYinYang() throws IOException {
        levelMenuViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawYinYang(List.of(new Position(1, 1)), List.of(new Position(2, 2)));
        Mockito.verify(gui, Mockito.times(1)).drawYinYang(Mockito.any(), Mockito.any());
    }
    @Test
    void drawBorder() throws IOException {
        levelMenuViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawBorder(List.of(new Position(0, 0)));
        Mockito.verify(gui, Mockito.times(1)).drawBorder(Mockito.any());
    }
}
