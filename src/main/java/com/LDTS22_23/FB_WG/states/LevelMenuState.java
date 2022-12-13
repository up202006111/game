package com.LDTS22_23.FB_WG.states;

import com.LDTS22_23.FB_WG.controller.Controller;
import com.LDTS22_23.FB_WG.controller.menu.LevelMenuController;
import com.LDTS22_23.FB_WG.model.menu.LevelMenu;
import com.LDTS22_23.FB_WG.viewer.Viewer;
import com.LDTS22_23.FB_WG.viewer.menu.LevelMenuViewer;

public class LevelMenuState extends State<LevelMenu> {
    public LevelMenuState(LevelMenu levelMenu) {super(levelMenu);}
    @Override
    protected Viewer<LevelMenu> getViewer() {return new LevelMenuViewer(getModel());}
    @Override
    protected Controller<LevelMenu> getController() {return new LevelMenuController(getModel());}
}
