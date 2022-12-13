package com.LDTS22_23.FB_WG;

import com.LDTS22_23.FB_WG.gui.LanternaGUI;
import com.LDTS22_23.FB_WG.model.menu.LoaderMenuBuilder;
import com.LDTS22_23.FB_WG.states.GameMenuState;
import com.LDTS22_23.FB_WG.states.State;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    private int LevelNumber;

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }
    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(40, 40);
        this.state = new GameMenuState(new LoaderMenuBuilder().createGameMenu());
    }
    public void setState(State state) {this.state = state;}
    public void setLevelNumber(int levelNumber) {LevelNumber = levelNumber;}
    public int getLevelNumber() {return LevelNumber;}
    private void start() throws IOException {
        int FPS = 10;
        int frameTime = 1000 / FPS;
        while (this.state != null) {
            long startTime = System.currentTimeMillis();
            state.step(this, gui, startTime);
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException ignored) {}
        }
        gui.close();
    }
}
