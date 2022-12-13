package com.LDTS22_23.FB_WG.model.menu;

import java.util.Arrays;

public class InstructionsMenu extends Menu {
    public InstructionsMenu() {super(Arrays.asList("WaterGirl and FireBoy", "Pools", "Diamonds", "Doors", "Buttons, Elevators and Levers", "Boxes", "<- Go back"));}
    public boolean isSelectedWandF() {return isSelected(0);}
    public boolean isSelectedPools() {return isSelected(1);}
    public boolean isSelectedDiamonds() {return isSelected(2);}
    public boolean isSelectedDoors() {return isSelected(3);}
    public boolean isSelectedB_E_L() {return isSelected(4);}
    public boolean isSelectedBoxes() {return isSelected(5);}
    public boolean isSelectedGoBack() {return isSelected(6);}
}
