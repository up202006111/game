package com.LDTS22_23.FB_WG.model.menu;

import java.util.Arrays;

public class GameMenu extends Menu {
    public GameMenu() {super(Arrays.asList("Start", "Instructions", "Exit"));}
    public boolean isSelectedExit() {return isSelected(2);}
    public boolean isSelectedInstructions() {return isSelected(1);}
    public boolean isSelectedStart() {return isSelected(0);}
}
