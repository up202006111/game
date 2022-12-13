package com.LDTS22_23.FB_WG.gui;

import com.LDTS22_23.FB_WG.model.Position;
import java.io.IOException;
import java.util.List;

public interface GUI {
    ACTION getNextAction() throws IOException;
    void drawBackground();
    void drawYinYang(List<Position> red, List<Position> blue);
    void drawBorder(List<Position> border);
    void drawWall(Position position);
    void drawPool(Position position, int type);
    void drawElevator(Position position);
    void drawLever(Position position, int pressed);
    void drawDiamond(Position position, int type);
    void drawBox(Position position);
    void drawDoor(Position position, int type);
    void drawFireBoy(Position position);
    void drawWaterGirl(Position position);
    void drawText(Position position, String text, String color);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
    enum ACTION {UP_F, RIGHT_F, DOWN_F, LEFT_F, UP_W, RIGHT_W, DOWN_W, LEFT_W, NONE, QUIT, SELECT}
}
