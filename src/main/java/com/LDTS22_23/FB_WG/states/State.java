package com.LDTS22_23.FB_WG.states;

import com.LDTS22_23.FB_WG.Game;
import com.LDTS22_23.FB_WG.controller.Controller;
import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.viewer.Viewer;
import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;
    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }
    protected abstract Viewer<T> getViewer();
    protected abstract Controller<T> getController();
    public T getModel() {return model;}
    public void step(Game game, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }
}
