package com.LDTS22_23.FB_WG.model.game.level;

import com.LDTS22_23.FB_WG.model.game.elements.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderLevelBuilder extends LevelBuilder {
    private final List<String> lines = new ArrayList<>();
    public LoaderLevelBuilder(int level) throws IOException {
        URL resource = LoaderLevelBuilder.class.getResource("/Levels/Level" + level + ".txt");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        for (String line; (line = br.readLine()) != null;)
            lines.add(line);
    }
    public List<Wall> createWalls() {
        List<Wall> Walls = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') Walls.add(new Wall(x, y));
        }
        return Walls;
    }
    public List<Pool> createPools() {
        List<Pool> Pools = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'A') Pools.add(new Pool(x, y, 0));
                if (line.charAt(x) == 'L') Pools.add(new Pool(x, y, 1));
                if (line.charAt(x) == 'l') Pools.add(new Pool(x, y, 2));
            }
        }
        return Pools;
    }
    public List<Lever> createLevers() {
        List<Lever> Levers = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'b') {
                    int i = line.charAt(x + 1);
                    Levers.add(new Lever(x, y, i, 0));
                }
            }
        }
        return Levers;
    }
    public List<Elevator> createElevators() {
        List<Elevator> Elevators = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'E') {
                    int i = line.charAt(x + 1);
                    Elevators.add(new Elevator(x, y, y, i));
                    Elevators.add(new Elevator(x + 1, y, y, i));
                    Elevators.add(new Elevator(x + 2, y, y, i));
                    Elevators.add(new Elevator(x + 3, y, y, i));
                    Elevators.add(new Elevator(x + 4, y, y, i));
                }
            }
        }
        return Elevators;
    }
    public ArrayList<Diamond> createDiamonds() {
        ArrayList<Diamond> Diamonds = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'D') Diamonds.add(new Diamond(x, y, 0));
                if (line.charAt(x) == 'd') Diamonds.add(new Diamond(x, y, 1));
            }
        }
        return Diamonds;
    }
    public List<Door> createDoors() {
        List<Door> Doors = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'P') Doors.add(new Door(x, y, 0));
                if (line.charAt(x) == 'p') Doors.add(new Door(x, y, 1));
            }
        }
        return Doors;
    }
    public List<Box> createBoxes() {
        List<Box> Boxes = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'O') {
                    int i = line.charAt(x + 1);
                    Boxes.add(new Box(x, y, 3, i));
                    Boxes.add(new Box(x + 1, y, 3, i));
                    Boxes.add(new Box(x, y + 1, 0, i));
                    Boxes.add(new Box(x + 1, y + 1, 1, i));
                }
            }
        }
        return Boxes;
    }
    public FireBoy createFireBoy() {
        FireBoy fireBoy = null;
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'F') fireBoy = new FireBoy(x, y);
            }
        }
        return fireBoy;
    }
    public WaterGirl createWaterGirl() {
        WaterGirl waterGirl = null;
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'W') waterGirl = new WaterGirl(x, y);
            }
        }
        return waterGirl;
    }
}
