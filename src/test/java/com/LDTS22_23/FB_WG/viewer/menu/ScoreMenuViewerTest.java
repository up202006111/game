package com.LDTS22_23.FB_WG.viewer.menu;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.Position;
import com.LDTS22_23.FB_WG.model.menu.ScoreMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.List;

public class ScoreMenuViewerTest {
    private GUI gui;
    private ScoreMenuViewer scoreMenuViewer;
    private ScoreMenu scoreMenu;
    @BeforeEach
    void setUp() {
        scoreMenu = new ScoreMenu();
        scoreMenu.setRed(List.of(new Position(1, 1)));
        scoreMenu.setBlue(List.of(new Position(2, 2)));
        scoreMenu.setBorder(List.of(new Position(0, 0)));
        gui = Mockito.mock(GUI.class);
        scoreMenuViewer = new ScoreMenuViewer(scoreMenu);
    }
    @Test
    void drawYinYang() throws IOException {
        scoreMenu.setScore(0);
        scoreMenuViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawYinYang(List.of(new Position(1, 1)), List.of(new Position(2, 2)));
        Mockito.verify(gui, Mockito.times(1)).drawYinYang(Mockito.any(), Mockito.any());
    }
    @Test
    void drawBorder() throws IOException {
        scoreMenu.setScore(1);
        scoreMenuViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawBorder(List.of(new Position(0, 0)));
        Mockito.verify(gui, Mockito.times(1)).drawBorder(Mockito.any());
    }
}
