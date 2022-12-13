package com.LDTS22_23.FB_WG.states;

import com.LDTS22_23.FB_WG.controller.Controller;
import com.LDTS22_23.FB_WG.controller.game.LevelController;
import com.LDTS22_23.FB_WG.model.game.level.Level;
import com.LDTS22_23.FB_WG.viewer.Viewer;
import com.LDTS22_23.FB_WG.viewer.game.GameViewer;

public class GameState extends State<Level> {
    public GameState(Level level) {super(level);}
    @Override
    protected Viewer<Level> getViewer() {return new GameViewer(getModel());}
    @Override
    protected Controller<Level> getController() {return new LevelController(getModel());}
}
