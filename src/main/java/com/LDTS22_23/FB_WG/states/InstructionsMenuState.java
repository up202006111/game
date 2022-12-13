package com.LDTS22_23.FB_WG.states;

import com.LDTS22_23.FB_WG.controller.Controller;
import com.LDTS22_23.FB_WG.controller.menu.InstructionsMenuController;
import com.LDTS22_23.FB_WG.model.menu.InstructionsMenu;
import com.LDTS22_23.FB_WG.viewer.Viewer;
import com.LDTS22_23.FB_WG.viewer.menu.InstructionsMenuViewer;

public class InstructionsMenuState extends State<InstructionsMenu> {
    public InstructionsMenuState(InstructionsMenu instructionsMenu) {super(instructionsMenu);}
    @Override
    protected Viewer<InstructionsMenu> getViewer() {return new InstructionsMenuViewer(getModel());}
    @Override
    protected Controller<InstructionsMenu> getController() {return new InstructionsMenuController(getModel());}
}
