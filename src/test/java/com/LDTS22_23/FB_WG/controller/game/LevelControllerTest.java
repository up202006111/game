package com.LDTS22_23.FB_WG.controller.game;

import com.LDTS22_23.FB_WG.Game;
import com.LDTS22_23.FB_WG.gui.GUI;
import com.LDTS22_23.FB_WG.model.game.elements.Door;
import com.LDTS22_23.FB_WG.model.game.elements.Pool;
import com.LDTS22_23.FB_WG.model.game.level.Level;
import com.LDTS22_23.FB_WG.model.game.level.RandomLevelBuilder;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LevelControllerTest {
    private final Game game = Mockito.mock(Game.class);
    @Test
    void levelWin() throws IOException {
        Level level = new RandomLevelBuilder(10, 10).createLevel();
        level.setDoors(Arrays.asList(new Door(6, 5, 0), new Door(4, 5, 1)));
        LevelController levelController = new LevelController(level);

        levelController.step(game, GUI.ACTION.RIGHT_F, 1000);
        levelController.step(game, GUI.ACTION.LEFT_W, 1000);
        levelController.step(game, GUI.ACTION.NONE, 1000);
    }
    @Test
    void levelLose() throws IOException {
        Level level = new RandomLevelBuilder(10, 10).createLevel();
        level.setPools(Arrays.asList(new Pool(6,5,0), new Pool(4,5,1), new Pool(5,4,2)));
        LevelController levelController = new LevelController(level);

        levelController.step(game, GUI.ACTION.RIGHT_W, 1000);
        levelController.step(game, GUI.ACTION.RIGHT_F, 1000);
        levelController.step(game, GUI.ACTION.LEFT_W, 1000);
        levelController.step(game, GUI.ACTION.UP_F, 1000);
        levelController.step(game, GUI.ACTION.QUIT, 1000);
    }
    @Property
    void allLevelsAreClosed(@ForAll @IntRange(min = 3, max = 50) int width, @ForAll @IntRange(min = 3, max = 50) int height,
                            @ForAll java.util.List<GUI.ACTION> actionsFireBoy, @ForAll List<GUI.ACTION> actionsWaterGirl) {

        actionsFireBoy.add(GUI.ACTION.UP_F);    actionsFireBoy.add(GUI.ACTION.RIGHT_F);
        actionsFireBoy.add(GUI.ACTION.LEFT_F);
        actionsWaterGirl.add(GUI.ACTION.UP_W);  actionsWaterGirl.add(GUI.ACTION.RIGHT_W);
        actionsWaterGirl.add(GUI.ACTION.LEFT_W);

        Level level = new RandomLevelBuilder(width, height).createLevel();
        CharacterController characterController = new CharacterController(level);
        for (GUI.ACTION action : actionsFireBoy) {
            characterController.step(game, action, 100);
            assert (characterController.getModel().getFireBoy().getPosition().get_x() > 0);
            assert (characterController.getModel().getFireBoy().getPosition().get_y() > 0);
            assert (characterController.getModel().getFireBoy().getPosition().get_x() < width);
            assert (characterController.getModel().getFireBoy().getPosition().get_y() < height);
        }
        for (GUI.ACTION action : actionsWaterGirl) {
            characterController.step(game, action, 100);
            assert (characterController.getModel().getWaterGirl().getPosition().get_x() > 0);
            assert (characterController.getModel().getWaterGirl().getPosition().get_y() > 0);
            assert (characterController.getModel().getWaterGirl().getPosition().get_x() < width);
            assert (characterController.getModel().getWaterGirl().getPosition().get_y() < height);
        }
    }
}
