package com.LDTS22_23.FB_WG.viewer.menu;

import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.Position;
import com.LDTS22_23.FB_WG.model.menu.InstructionsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.List;

public class InstructionsMenuViewerTest {
    private GUI gui;
    private InstructionsMenuViewer instructionsMenuViewer;
    private InstructionsMenu instructionsMenu;
    @BeforeEach
    void setUp() {
        instructionsMenu = new InstructionsMenu();
        gui = Mockito.mock(GUI.class);
        instructionsMenuViewer = new InstructionsMenuViewer(instructionsMenu);
        instructionsMenu.setRed(List.of(new Position(1, 1)));
        instructionsMenu.setBlue(List.of(new Position(2, 2)));
        instructionsMenu.setBorder(List.of(new Position(0, 0)));
    }
    @Test
    void drawYinYang() throws IOException {
        instructionsMenuViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawYinYang(List.of(new Position(1, 1)), List.of(new Position(2, 2)));
        Mockito.verify(gui, Mockito.times(1)).drawYinYang(Mockito.any(), Mockito.any());
    }
    @Test
    void drawBorder() throws IOException {
        instructionsMenu.nextEntry();
        instructionsMenuViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawBorder(List.of(new Position(0, 0)));
        Mockito.verify(gui, Mockito.times(1)).drawBorder(Mockito.any());
    }
    @Test
    void drawText3() throws IOException {
        instructionsMenu.nextEntry();
        instructionsMenu.nextEntry();
        instructionsMenuViewer.draw(gui);
    }
    @Test
    void drawText4() throws IOException {
        instructionsMenu.nextEntry();
        instructionsMenu.nextEntry();
        instructionsMenu.nextEntry();
        instructionsMenuViewer.draw(gui);
    }
    @Test
    void drawText5() throws IOException {
        instructionsMenu.nextEntry();
        instructionsMenu.nextEntry();
        instructionsMenu.nextEntry();
        instructionsMenu.nextEntry();
        instructionsMenuViewer.draw(gui);
    }
    @Test
    void drawText6() throws IOException {
        instructionsMenu.nextEntry();
        instructionsMenu.nextEntry();
        instructionsMenu.nextEntry();
        instructionsMenu.nextEntry();
        instructionsMenu.nextEntry();
        instructionsMenuViewer.draw(gui);
    }
}
