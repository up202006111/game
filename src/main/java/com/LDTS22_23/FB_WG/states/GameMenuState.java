package com.LDTS22_23.FB_WG.states;

import com.LDTS22_23.FB_WG.controller.Controller;
import com.LDTS22_23.FB_WG.controller.menu.GameMenuController;
import com.LDTS22_23.FB_WG.model.menu.GameMenu;
import com.LDTS22_23.FB_WG.viewer.Viewer;
import com.LDTS22_23.FB_WG.viewer.menu.GameMenuViewer;

public class GameMenuState extends State<GameMenu> {
    public GameMenuState(GameMenu gameMenu) {super(gameMenu);}
    @Override
    protected Viewer<GameMenu> getViewer() {return new GameMenuViewer(getModel());}
    @Override
    protected Controller<GameMenu> getController() {return new GameMenuController(getModel());}
}
