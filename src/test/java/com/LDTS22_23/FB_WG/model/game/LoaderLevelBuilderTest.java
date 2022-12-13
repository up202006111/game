package com.LDTS22_23.FB_WG.model.game;

import com.LDTS22_23.FB_WG.model.game.level.LoaderLevelBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class LoaderLevelBuilderTest {
    private LoaderLevelBuilder loaderLevelBuilder;
    @BeforeEach
    void setUp() throws IOException {
        loaderLevelBuilder = new LoaderLevelBuilder(1);
    }
    @Test
    void createWalls() {
        loaderLevelBuilder.createWalls();
    }
    @Test
    void createPools() {
        loaderLevelBuilder.createPools();
    }
    @Test
    void createLevers() {
        loaderLevelBuilder.createLevers();
    }
    @Test
    void createElevators() {
        loaderLevelBuilder.createElevators();
    }
    @Test
    void createDiamonds() {
        loaderLevelBuilder.createDiamonds();
    }
    @Test
    void createDoors() {
        loaderLevelBuilder.createDoors();
    }
    @Test
    void createBoxes() {
        loaderLevelBuilder.createBoxes();
    }
    @Test
    void createFireBoy() {
        loaderLevelBuilder.createFireBoy();
    }
    @Test
    void createWaterGirl() {
        loaderLevelBuilder.createWaterGirl();
    }
}
