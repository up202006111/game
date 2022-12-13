package com.LDTS22_23.FB_WG.gui;

import com.LDTS22_23.FB_WG.model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class LanternaGUI implements GUI {
    private final Screen screen;
    private final int width;
    private final int height;
    public LanternaGUI(Screen screen) {this.screen = screen; this.width = getWidth(); this.height = getHeight();}
    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        this.width = width;
        this.height = height;
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }
    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        return terminalFactory.createTerminal();
    }
    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        assert resource != null;
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, 20);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;
        switch (keyStroke.getKeyType()) {
            case EOF, Escape -> {return ACTION.QUIT;}
            case ArrowUp -> {return ACTION.UP_F;}
            case ArrowRight -> {return ACTION.RIGHT_F;}
            case ArrowDown -> {return ACTION.DOWN_F;}
            case ArrowLeft -> {return ACTION.LEFT_F;}
            case Enter -> {return ACTION.SELECT;}
            case Character -> {
                switch (keyStroke.getCharacter()) {
                    case 'q' -> {return ACTION.QUIT;}
                    case 'w' -> {return ACTION.UP_W;}
                    case 'a' -> {return ACTION.LEFT_W;}
                    case 's' -> {return ACTION.DOWN_W;}
                    case 'd' -> {return ACTION.RIGHT_W;}
                }
            }
        }
        return ACTION.NONE;
    }
    @Override
    public void drawBackground() {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#76551f"));
        textGraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    }
    @Override
    public void drawYinYang(List<Position> red, List<Position> blue) {
        for (Position position : red) {
            drawText(position, " ", "#d01e1e");
        }
        for (Position position : blue) {
            drawText(position, " ", "#3d87d1");
        }
    }
    @Override
    public void drawBorder(List<Position> border) {
        for (Position position : border) {
            drawWall(position);
        }
    }
    @Override
    public void drawWall(Position position) {drawCharacter(position.get_x(), position.get_y(), '#', "#9ea783");}
    @Override
    public void drawPool(Position position, int type) {
        if (type == 0) {
            drawText(position, " ", "#6ecf2b");
        } else if (type == 1) {
            drawText(position, " ", "#d01e1e");
        } else {
            drawText(position, " ", "#3d87d1");
        }
    }
    @Override
    public void drawElevator(Position position) {drawCharacter(position.get_x(), position.get_y(), 'E', "#6ecf2b");}
    @Override
    public void drawLever(Position position, int pressed) {
        if (pressed == 0) {
            drawCharacter(position.get_x(), position.get_y(), '/', "#FFFFFF");
        } else {
            drawCharacter(position.get_x(), position.get_y(), '|', "#000000");
        }
    }
    @Override
    public void drawDiamond(Position position, int type) {
        if (type == 0) {
            drawCharacter(position.get_x(), position.get_y(), 'D', "#d01e1e");
        } else {
            drawCharacter(position.get_x(), position.get_y(), 'D', "#3d87d1");
        }
    }
    @Override
    public void drawBox(Position position) {drawCharacter(position.get_x(), position.get_y(), 'O', "#94904E");}
    @Override
    public void drawDoor(Position position, int type) {
        if (type == 0) {
            drawText(position, " ", "#d01e1e");
        } else {
            drawText(position, " ", "#3d87d1");
        }
    }
    @Override
    public void drawFireBoy(Position position) {drawCharacter(position.get_x(), position.get_y(), 'F', "#d01e1e");}
    @Override
    public void drawWaterGirl(Position position) {drawCharacter(position.get_x(), position.get_y(), 'W', "#3d87d1");}
    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics textGraphics = screen.newTextGraphics();
        if (!Objects.equals(text, " ")) {
            textGraphics.setBackgroundColor(TextColor.Factory.fromString("#76551f"));
            textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
            textGraphics.putString(position.get_x(), position.get_y(), text);
        } else {
            textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
            textGraphics.putString(position.get_x(), position.get_y(), text);
        }
    }
    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics textGraphics = screen.newTextGraphics();
        if (c == '#') {
            textGraphics.setBackgroundColor(TextColor.Factory.fromString("#7e5a1f"));
        } else {
            textGraphics.setBackgroundColor(TextColor.Factory.fromString("#76551f"));
        }
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(x, y, "" + c);
    }
    @Override
    public void clear() {screen.clear();}
    @Override
    public void refresh() throws IOException {screen.refresh();}
    @Override
    public void close() throws IOException {screen.close();}
}
