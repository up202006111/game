package com.LDTS22_23.FB_WG.model.game.level;

import com.LDTS22_23.FB_WG.model.game.elements.*;
import java.util.ArrayList;
import java.util.List;

public abstract class LevelBuilder {
    public Level createLevel() {
        Level level = new Level();
        level.setWalls(createWalls());
        level.setPools(createPools());
        level.setElevators(createElevators());
        level.setDiamonds(createDiamonds());
        level.setBoxes(createBoxes());
        level.setDoors(createDoors());
        level.setFireBoy(createFireBoy());
        level.setWaterGirl(createWaterGirl());
        level.setLevers(createLevers());
        return level;
    }
    protected abstract List<Wall> createWalls();
    protected abstract List<Pool> createPools();
    protected abstract List<Lever> createLevers();
    protected abstract List<Elevator> createElevators();
    protected abstract ArrayList<Diamond> createDiamonds();
    protected abstract List<Door> createDoors();
    protected abstract List<Box> createBoxes();
    protected abstract FireBoy createFireBoy();
    protected abstract WaterGirl createWaterGirl();
}
