package com.LDTS22_23.FB_WG.controller.game;

import com.LDTS22_23.FB_WG.controller.Controller;
import com.LDTS22_23.FB_WG.model.game.level.Level;

public abstract class GameController extends Controller<Level> {
    public GameController(Level level) {super(level);}
}
