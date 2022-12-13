package com.LDTS22_23.FB_WG.model.game.level;

import com.LDTS22_23.FB_WG.model.game.elements.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLevelBuilder extends LevelBuilder {
    private final Random rng;
    private final int width;
    private final int height;
    public RandomLevelBuilder(int width, int height) {
        this.rng = new Random();
        this.width = width;
        this.height = height;
    }
    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int x = 0; x < width; x++) {
            walls.add(new Wall(x, 0));
            walls.add(new Wall(x, height));
        }
        for (int y = 1; y < height; y++) {
            walls.add(new Wall(0, y));
            walls.add(new Wall(width, y));
        }
        return walls;
    }
    @Override
    protected List<Pool> createPools() {
        List<Pool> pools = new ArrayList<>();
        while (pools.size() < 15) {
            pools.add(new Pool(rng.nextInt(width - 1) + 1, rng.nextInt(height - 1) + 1, rng.nextInt(3)));
        }
        return pools;
    }
    @Override
    protected List<Lever> createLevers() {
        List<Lever> levers = new ArrayList<>();
        while (levers.size() < 10) {
            levers.add(new Lever(rng.nextInt(width - 1) + 1, rng.nextInt(height - 1) + 1, rng.nextInt(2), rng.nextInt(2)));
        }
        return levers;
    }
    @Override
    protected List<Elevator> createElevators() {
        List<Elevator> elevators = new ArrayList<>();
        while (elevators.size() < 10) {
            elevators.add(new Elevator(rng.nextInt(width - 1) + 1, rng.nextInt(height - 1) + 1, rng.nextInt(height - 1) + 1, rng.nextInt(2)));
        }
        return elevators;
    }
    @Override
    protected ArrayList<Diamond> createDiamonds() {
        ArrayList<Diamond> diamonds = new ArrayList<>();
        while (diamonds.size() < 10) {
            diamonds.add(new Diamond(rng.nextInt(width - 1) + 1, rng.nextInt(height - 1) + 1, rng.nextInt(2)));
        }
        return diamonds;
    }
    @Override
    protected List<Door> createDoors() {
        List<Door> doors = new ArrayList<>();
        while (doors.size() < 8) {
            doors.add(new Door(rng.nextInt(width - 1) + 1, rng.nextInt(height - 1) + 1, 0));
            doors.add(new Door(rng.nextInt(width - 1) + 1, rng.nextInt(height - 1) + 1, 1));
        }
        return doors;
    }
    @Override
    protected List<Box> createBoxes() {
        List<Box> boxes = new ArrayList<>();
        while (boxes.size() < 8) {
            boxes.add(new Box(rng.nextInt(width - 1) + 1, rng.nextInt(height - 1) + 1, rng.nextInt(2), rng.nextInt(2)));
        }
        return boxes;
    }
    @Override
    protected FireBoy createFireBoy() {return new FireBoy(width / 2, height / 2);}
    @Override
    protected WaterGirl createWaterGirl() {return new WaterGirl(width / 2, height / 2);}
}