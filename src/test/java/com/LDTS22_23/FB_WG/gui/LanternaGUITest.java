package com.LDTS22_23.FB_WG.gui;

import com.LDTS22_23.FB_WG.model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LanternaGUITest {
    private LanternaGUI gui;
    private TextGraphics textGraphics;
    private Screen screen;
    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        textGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);
        gui = new LanternaGUI(screen);
    }
    @Test
    void drawBackground() {
        gui.drawBackground();
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#76551f"));
        Mockito.verify(textGraphics, Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(0, 0), ' ');
    }
    @Test
    void drawYinYang() {
        gui.drawYinYang(List.of(new Position(1, 1)), List.of(new Position(2, 2)));
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#d01e1e"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, " ");
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#3d87d1"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(2, 2, " ");
    }
    @Test
    void drawBorder() {
        gui.drawBorder(List.of(new Position(0, 0)));
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#7e5a1f"));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#9ea783"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(0, 0, "#");
    }
    @Test
    void drawWall() {
        gui.drawWall(new Position(1, 1));
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#7e5a1f"));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#9ea783"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "#");
    }
    @Test
    void drawPool() {
        gui.drawPool(new Position(1, 1), 0);
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#6ecf2b"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, " ");
        gui.drawPool(new Position(1, 2), 1);
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#d01e1e"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 2, " ");
        gui.drawPool(new Position(1, 3), 2);
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#3d87d1"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 3, " ");
    }
    @Test
    void drawElevator() {
        gui.drawElevator(new Position(1, 1));
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#76551f"));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#6ecf2b"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "E");
    }
    @Test
    void drawLever0() {
        gui.drawLever(new Position(1, 1), 0);
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#76551f"));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "/");
    }
    @Test
    void drawLever1() {
        gui.drawLever(new Position(1, 1), 1);
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#76551f"));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "|");
    }
    @Test
    void drawDiamond0() {
        gui.drawDiamond(new Position(1, 1), 0);
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#76551f"));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#d01e1e"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "D");

    }
    @Test
    void drawDiamond1() {
        gui.drawDiamond(new Position(1, 1), 1);
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#76551f"));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#3d87d1"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "D");
    }
    @Test
    void drawBox() {
        gui.drawBox(new Position(1, 1));
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#76551f"));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#94904E"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "O");
    }
    @Test
    void drawDoor() {
        gui.drawDoor(new Position(1, 1), 0);
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#d01e1e"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, " ");
        gui.drawDoor(new Position(1, 2), 1);
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#3d87d1"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 2, " ");
    }
    @Test
    void drawFireBoy() {
        gui.drawFireBoy(new Position(1, 1));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#d01e1e"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "F");
    }
    @Test
    void drawWaterGirl() {
        gui.drawWaterGirl(new Position(1, 1));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#3d87d1"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "W");
    }
    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#336699");
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#336699"));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "Hello World");
    }
    @Test
    public void clear() {
        gui.clear();
        Mockito.verify(screen, Mockito.times(1)).clear();
    }
    @Test
    public void refresh() throws IOException {
        gui.refresh();
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }
    @Test
    public void close() throws IOException {
        gui.close();
        Mockito.verify(screen, Mockito.times(1)).close();
    }
    @Test
    public void getNextAction() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(null);
        assertEquals(GUI.ACTION.NONE, gui.getNextAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));
        assertEquals(GUI.ACTION.UP_F, gui.getNextAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft));
        assertEquals(GUI.ACTION.LEFT_F, gui.getNextAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowRight));
        assertEquals(GUI.ACTION.RIGHT_F, gui.getNextAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown));
        assertEquals(GUI.ACTION.DOWN_F, gui.getNextAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('w', false, false));
        assertEquals(GUI.ACTION.UP_W, gui.getNextAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('a', false, false));
        assertEquals(GUI.ACTION.LEFT_W, gui.getNextAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('s', false, false));
        assertEquals(GUI.ACTION.DOWN_W, gui.getNextAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('d', false, false));
        assertEquals(GUI.ACTION.RIGHT_W, gui.getNextAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('q', false, false));
        assertEquals(GUI.ACTION.QUIT, gui.getNextAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.EOF));
        assertEquals(GUI.ACTION.QUIT, gui.getNextAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Escape));
        assertEquals(GUI.ACTION.QUIT, gui.getNextAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Enter));
        assertEquals(GUI.ACTION.SELECT, gui.getNextAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Backspace));
        assertEquals(GUI.ACTION.NONE, gui.getNextAction());
    }
}