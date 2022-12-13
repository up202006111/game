package com.LDTS22_23.FB_WG.model.menu;

import com.LDTS22_23.FB_WG.model.Position;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MenuBuilderTest {
    private static MenuBuilder menuBuilder;
    @BeforeAll
    static void setUp() {
        menuBuilder = new MenuBuilder() {
            @Override
            protected List<Position> createRed() {return List.of(new Position(1,2));}
            @Override
            protected List<Position> createBlue() {return List.of(new Position(2,1));}
            @Override
            protected List<Position> createBorder() {return List.of(new Position(0,0));}
        };
    }
    @Test
    void createGameMenu() {
        GameMenu gameMenu = menuBuilder.createGameMenu();
        assert (gameMenu.getRed().equals(List.of(new Position(1,2))));
        assert (gameMenu.getBlue().equals(List.of(new Position(2,1))));
        assert (gameMenu.getBorder().equals(List.of(new Position(0,0))));
    }

    @Test
    void createLevelMenu() {
        LevelMenu levelMenu = menuBuilder.createLevelMenu();
        assert (levelMenu.getRed().equals(List.of(new Position(1,2))));
        assert (levelMenu.getBlue().equals(List.of(new Position(2,1))));
        assert (levelMenu.getBorder().equals(List.of(new Position(0,0))));
    }

    @Test
    void createScoreMenu() {
        ScoreMenu scoreMenu = menuBuilder.createScoreMenu(0, 0, 0);
        assert (scoreMenu.getRed().equals(List.of(new Position(1,2))));
        assert (scoreMenu.getBlue().equals(List.of(new Position(2,1))));
        assert (scoreMenu.getBorder().equals(List.of(new Position(0,0))));
        assert (scoreMenu.getRedDiamonds() == 0);
        assert (scoreMenu.getBlueDiamonds() == 0);
    }

}
