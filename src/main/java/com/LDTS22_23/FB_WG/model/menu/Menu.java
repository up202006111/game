package com.LDTS22_23.FB_WG.model.menu;

import com.LDTS22_23.FB_WG.model.Position;
import java.util.List;

public abstract class Menu {
    private List<Position> Red;
    private List<Position> Blue;
    private List<Position> Border;
    private final List<String> entries;
    private int currentEntry = 0;
    public Menu(List<String> entries) {this.entries = entries;}
    public int getNumberEntries() {return entries.size();}
    public String getEntry(int i) {return entries.get(i);}
    public int getCurrentEntry() {return currentEntry;}
    public List<Position> getRed() {return Red;}
    public List<Position> getBlue() {return Blue;}
    public List<Position> getBorder() {return Border;}
    public void setRed(List<Position> Red) {this.Red = Red;}
    public void setBlue(List<Position> Blue) {this.Blue = Blue;}
    public void setBorder(List<Position> Border) {this.Border = Border;}
    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }
    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }
    public boolean isSelected(int i) {return currentEntry == i;}
}
