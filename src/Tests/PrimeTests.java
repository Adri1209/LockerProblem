package Tests;

import Logic.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PrimeTests {


    @Test
    public void checkCorrectCubeTimeSquares() {

        Main main = new Main();
        List<Long> expectedValues = new ArrayList<>(Arrays.asList(1l, 2l, 3l, 5l, 6l, 7l, 8l, 10l, 11l, 13l, 14l, 15l, 16l, 17l, 19l, 21l, 22l, 23l, 24l, 26l, 27l, 29l, 30l, 31l, 33l, 34l, 35l, 37l, 38l, 39l, 40l, 41l, 42l, 43l, 46l, 47l, 48l, 51l, 53l, 54l, 55l, 56l, 57l, 58l, 59l, 61l, 62l, 64l, 65l, 66l, 67l, 69l, 70l, 71l, 73l, 74l, 77l, 78l, 79l, 80l, 81l, 82l, 83l, 85l, 86l, 87l, 88l, 89l, 91l, 93l, 94l, 95l, 97l));
        List<Long> actualValues = new ArrayList<>(main.cubetimesquarefrees());
        Assert.assertEquals(expectedValues, actualValues);
    }

    @Test
    public void checkCorrectSquares() {

        Main main = new Main();
        List<Long> expectedValues = new ArrayList<>(Arrays.asList(1l, 2l, 3l, 5l, 6l, 7l, 10l, 11l, 13l, 14l, 15l, 17l, 19l, 21l, 22l, 23l, 26l, 29l, 30l, 31l, 33l, 34l, 35l, 37l, 38l, 39l, 41l, 42l, 43l, 46l, 47l, 51l, 53l, 55l, 57l, 58l, 59l, 61l, 62l, 65l, 66l, 67l, 69l, 70l, 71l, 73l, 74l, 77l, 78l, 79l, 82l, 83l, 85l, 86l, 87l, 89l, 91l, 93l, 94l, 95l, 97l));
        List<Long> actualValues = new ArrayList<>(main.squarefrees());
        Assert.assertEquals(expectedValues, actualValues);
    }
}
