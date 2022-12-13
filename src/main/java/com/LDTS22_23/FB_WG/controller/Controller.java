package com.LDTS22_23.FB_WG.controller;

import com.LDTS22_23.FB_WG.Game;
import com.LDTS22_23.FB_WG.gui.GUI;
import java.io.IOException;

public abstract class Controller<T> {
    private final T model;
    public Controller(T model) {this.model = model;}
    public T getModel() {return model;}
    public abstract void step(Game game, GUI.ACTION action, long time) throws IOException;
}
