package com.LDTS22_23.FB_WG.model.game.level;

import com.LDTS22_23.FB_WG.model.Position;
import com.LDTS22_23.FB_WG.model.game.elements.*;
import java.util.List;

public class Level {
    private WaterGirl WaterGirl;
    private FireBoy FireBoy;
    private List<Wall> Walls;
    private List<Pool> Pools;
    private List<Lever> Levers;
    private List<Elevator> Elevators;
    private List<Diamond> Diamonds;
    private List<Box> Boxes;
    private List<Door> Doors;
    public Level() {}
    public FireBoy getFireBoy() {return FireBoy;}
    public WaterGirl getWaterGirl() {return WaterGirl;}
    public List<Wall> getWalls() {return Walls;}
    public List<Pool> getPools() {return Pools;}
    public List<Lever> getLevers() {return Levers;}
    public List<Elevator> getElevators() {return Elevators;}
    public List<Diamond> getDiamonds() {return Diamonds;}
    public List<Box> getBoxes() {return Boxes;}
    public List<Door> getDoors() {return Doors;}
    public void setFireBoy(FireBoy fireBoy) {FireBoy = fireBoy;}
    public void setWaterGirl(WaterGirl waterGirl) {WaterGirl = waterGirl;}
    public void setWalls(List<Wall> walls) {Walls = walls;}
    public void setPools(List<Pool> pools) {Pools = pools;}
    public void setLevers(List<Lever> levers) {Levers = levers;}
    public void setElevators(List<Elevator> elevators) {Elevators = elevators;}
    public void setDiamonds(List<Diamond> diamonds) {Diamonds = diamonds;}
    public void setBoxes(List<Box> boxes) {Boxes = boxes;}
    public void setDoors(List<Door> doors) {Doors = doors;}
    public boolean canCharacterMove(Position position) {
        for (Wall wall : Walls) {
            if (wall.getPosition().equals(position)) return false;
        }
        for (Elevator elevator : Elevators) {
            if (elevator.getPosition().equals(position)) return false;
        }
        for (Box box : Boxes) {
            if (box.getPosition().equals(position)) {
                moveBoxes(box);
                return false;
            }
        }
        return true;
    }
    public boolean fallInTheAcidPool(Position position) {
        for (Pool pool : Pools) {
            if (pool.getType() == 0 && pool.getPosition().equals(position)) return true;
        }
        return false;
    }
    public boolean fallInTheLavaPool(Position position) {
        for (Pool pool : Pools) {
            if (pool.getType() == 1 && pool.getPosition().equals(position)) return true;
        }
        return false;
    }
    public boolean fallInTheWaterPool(Position position) {
        for (Pool pool : Pools) {
            if (pool.getType() == 2 && pool.getPosition().equals(position)) return true;
        }
        return false;
    }
    public boolean enterRedDoor(Position position) {
        for (Door door : Doors) {
            if (door.getType() == 0 && door.getPosition().equals(position)) return true;
        }
        return false;
    }
    public boolean enterBlueDoor(Position position) {
        for (Door door : Doors) {
            if (door.getType() == 1 && door.getPosition().equals(position)) return true;
        }
        return false;
    }
    public void retrieveFire(Position position) {
        Diamond toRemove = new Diamond(0, 0, 0);
        for (Diamond diamond : Diamonds) {
            if (diamond.getPosition().equals(position) && diamond.getType() == 0) {
                FireBoy.addRedDiamonds();
                toRemove = diamond;
            }
        }
        Diamonds.remove(toRemove);
    }
    public void retrieveWater(Position position) {
        Diamond toRemove = new Diamond(0,0,0);
        for (Diamond diamond : Diamonds) {
            if (diamond.getPosition().equals(position) && diamond.getType() == 1) {
                WaterGirl.addBlueDiamonds();
                toRemove = diamond;
            }
        }
        Diamonds.remove(toRemove);
    }
    public boolean canBoxMove(Position position) {
        for (Wall wall : Walls) {
            if (wall.getPosition().equals(position)) return false;
        }
        for (Box box : Boxes) {
            if (box.getPosition().equals(position)) return false;
        }
        for (Elevator elevator : Elevators) {
            if (elevator.getPosition().equals(position)) return false;
        }
        return true;
    }
    public void moveBoxes(Box box) {
        for (Box box1 : Boxes) {
            if (box1.getNumber() == box.getNumber()) {
                if (box.getSide() == 0) {
                    if (canBoxMove(box1.getPosition().moveRight().moveRight())) {
                        box1.setPosition(box1.getPosition().moveRight().moveRight());
                    }
                }
                if (box.getSide() == 1) {
                    if (canBoxMove(box1.getPosition().moveLeft().moveLeft())) {
                        box1.setPosition(box1.getPosition().moveLeft().moveLeft());
                    }
                }
            }
        }
    }
    public void gravityForBoxes() {
        for (Box box : Boxes) {
            if (canBoxMove(box.getPosition().moveDown()))
                box.setPosition(box.getPosition().moveDown());
        }
    }
    public void leverCallElevator(Position position) {
        for (Lever lever : Levers) {
            if (lever.getPosition().equals(position)) {
                lever.onAndOff();
                for (int i = 0; i < Elevators.size(); i++) {
                    if (lever.getNumber() == Elevators.get(i).getNumber()) {
                        if (lever.getPressed() == 0) {
                            Elevators.set(i, new Elevator(Elevators.get(i).getPosition().get_x(), Elevators.get(i).getInitial_y(), Elevators.get(i).getInitial_y(), Elevators.get(i).getNumber()));
                        }
                        if (lever.getPressed() == 1) {
                            Elevators.set(i, new Elevator(Elevators.get(i).getPosition().get_x(), Elevators.get(i).getPosition().get_y() + 3, Elevators.get(i).getInitial_y(), Elevators.get(i).getNumber()));
                        }
                    }
                }
            }
        }
    }
}
