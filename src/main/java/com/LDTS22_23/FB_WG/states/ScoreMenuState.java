package com.LDTS22_23.FB_WG.states;

import com.LDTS22_23.FB_WG.controller.Controller;
import com.LDTS22_23.FB_WG.controller.menu.ScoreMenuController;
import com.LDTS22_23.FB_WG.model.menu.ScoreMenu;
import com.LDTS22_23.FB_WG.viewer.Viewer;
import com.LDTS22_23.FB_WG.viewer.menu.ScoreMenuViewer;

public class ScoreMenuState extends State<ScoreMenu> {
    public ScoreMenuState(ScoreMenu scoreMenu) {super(scoreMenu);}
    @Override
    protected Viewer<ScoreMenu> getViewer() {return new ScoreMenuViewer(getModel());}
    @Override
    protected Controller<ScoreMenu> getController() {return new ScoreMenuController(getModel());}
}
