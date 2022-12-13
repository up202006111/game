package com.LDTS22_23.FB_WG.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class LoaderMenuBuilderTest {
    private LoaderMenuBuilder loaderMenuBuilder;
    private GameMenu gameMenu;
    @BeforeEach
    void setUp() throws IOException {
        loaderMenuBuilder = new LoaderMenuBuilder();
        gameMenu = loaderMenuBuilder.createGameMenu();
    }
    @Test
    void createRed() {
        loaderMenuBuilder.createRed();
        assert (gameMenu.getRed().equals(loaderMenuBuilder.createRed()));
    }
    @Test
    void createBlue() {
        loaderMenuBuilder.createBlue();
        assert (gameMenu.getBlue().equals(loaderMenuBuilder.createBlue()));
    }
    @Test
    void createBorder() {
        loaderMenuBuilder.createBorder();
        assert (gameMenu.getBorder().equals(loaderMenuBuilder.createBorder()));
    }
}
