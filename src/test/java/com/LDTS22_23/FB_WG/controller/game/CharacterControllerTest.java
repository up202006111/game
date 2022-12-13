package com.LDTS22_23.FB_WG.controller.game;

import com.LDTS22_23.FB_WG.model.Position;
import com.LDTS22_23.FB_WG.model.game.elements.*;
import com.LDTS22_23.FB_WG.model.game.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterControllerTest {
    private CharacterController characterController;
    private FireBoy fireBoy;
    private WaterGirl waterGirl;
    private Level level;
    @BeforeEach
    void setUp() {
        level = new Level();
        fireBoy = new FireBoy(5, 5);
        waterGirl = new WaterGirl(10, 10);
        level.setFireBoy(fireBoy);
        level.setWaterGirl(waterGirl);
        level.setWalls(List.of());
        level.setElevators(List.of());
        level.setBoxes(List.of());
        level.setLevers(List.of());
        level.setDiamonds(new ArrayList<>());
        characterController = new CharacterController(level);
    }
    @Test
    void moveFireBoyLeftEmpty() {
        characterController.moveFireBoyLeft();
        assertEquals(new Position(4, 5), fireBoy.getPosition());
    }
    @Test
    void moveFireBoyRightNotEmpty() {
        level.setWalls(List.of(new Wall(6, 5)));
        characterController.moveFireBoyRight();
        assertEquals(new Position(5, 5), fireBoy.getPosition());
    }
    @Test
    void moveWaterGirlLeftEmpty() {
        characterController.moveWaterGirlLeft();
        assertEquals(new Position(9, 10), waterGirl.getPosition());
    }
    @Test
    void moveWaterGirlRightNotEmpty() {
        level.setWalls(List.of(new Wall(11, 10)));
        characterController.moveWaterGirlRight();
        assertEquals(new Position(10, 10), waterGirl.getPosition());
    }
    @Test
    void moveFireBoyIntoWaterPool() {
        level.setPools(List.of(new Pool(6, 5, 2)));
        characterController.moveFireBoyRight();
        assertTrue(level.fallInTheWaterPool(fireBoy.getPosition()));
        assertFalse(level.fallInTheAcidPool(fireBoy.getPosition()));
        assertFalse(level.fallInTheLavaPool(fireBoy.getPosition()));
    }
    @Test
    void moveWaterGirlIntoLavaPool() {
        level.setPools(List.of(new Pool(11, 10, 1)));
        characterController.moveWaterGirlRight();
        assertTrue(level.fallInTheLavaPool(waterGirl.getPosition()));
        assertFalse(level.fallInTheAcidPool(waterGirl.getPosition()));
        assertFalse(level.fallInTheWaterPool(waterGirl.getPosition()));
    }
    @Test
    void moveFireBoyIntoRedDoor() {
        level.setDoors(List.of(new Door(6, 5, 0)));
        characterController.moveFireBoyRight();
        assertTrue(level.enterRedDoor(fireBoy.getPosition()));
        assertFalse(level.enterBlueDoor(fireBoy.getPosition()));
    }
    @Test
    void moveWaterGirlIntoBlueDoor() {
        level.setDoors(List.of(new Door(11, 10, 1)));
        characterController.moveWaterGirlRight();
        assertTrue(level.enterBlueDoor(waterGirl.getPosition()));
        assertFalse(level.enterRedDoor(waterGirl.getPosition()));
    }    @Test
    void retrieveFire() {
        ArrayList<Diamond> diamonds = new ArrayList<>();
        diamonds.add(new Diamond(6, 5, 0));
        level.setDiamonds(diamonds);
        characterController.moveFireBoyRight();
        assertEquals(1, fireBoy.getRedDiamonds());
    }
    @Test
    void retrieveWater() {
        ArrayList<Diamond> diamonds = new ArrayList<>();
        diamonds.add(new Diamond(11, 10, 1));
        level.setDiamonds(diamonds);
        characterController.moveWaterGirlRight();
        assertEquals(1, waterGirl.getBlueDiamonds());
    }
}