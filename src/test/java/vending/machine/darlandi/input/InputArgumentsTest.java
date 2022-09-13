package vending.machine.darlandi.input;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class InputArgumentsTest {

    @Test
    @UseDataProvider("invalidParameters")
    public void nullWhenInvalidParameter(Input input, String parameterName) {
        String parameter = input.getParameter(parameterName);

        assertNull(parameter);
    }

    @Test
    @UseDataProvider("drinkTypeInput")
    public void validateDrinkTypeParameter(Input input, String parameterName, String drinkExpected) {
        String drinkType = input.getParameter(parameterName);

        assertEquals(drinkExpected, drinkType);
    }

    @Test
    @UseDataProvider("moneyInput")
    public void validateMoneyParameter(Input input, String parameterName, Float moneyExpected) {
        Float money = input.getParameter(parameterName);

        assertEquals(moneyExpected, money);
    }

    @Test
    @UseDataProvider("sugarInput")
    public void validateSugarParameter(Input input, String parameterName, int sugarExpected) {
        int sugar = input.getParameter(parameterName);

        assertEquals(sugarExpected, sugar);
    }

    @Test
    @UseDataProvider("extraHotInput")
    public void validateExtraHotParameter(Input input, String parameterName, boolean extraHotExpected) {
        boolean extraHot = input.getParameter(parameterName);

        assertEquals(extraHotExpected, extraHot);
    }

    @DataProvider
    public static Object[][] invalidParameters() {
        return new Object[][]{
                {new InputArguments("coffee", 1.5f, 1, false), "drinkTyp"},
                {new InputArguments("tea", 1f, 2, true), "sugaras"},
                {new InputArguments("chocolate", 0.1f, 2, true), ""},
                {new InputArguments("chocolate", 0.1f, 2, true), "cost"},
        };
    }

    @DataProvider
    public static Object[][] drinkTypeInput() {
        return new Object[][]{
                {new InputArguments("coffee", 1.5f, 1, false), "drinkType", "coffee"},
                {new InputArguments("tea", 1f, 2, true), "drinkType", "tea"},
                {new InputArguments("chocolate", 0.1f, 2, true), "drinkType", "chocolate"},
        };
    }

    @DataProvider
    public static Object[][] moneyInput() {
        return new Object[][]{
                {new InputArguments("coffee", 1.5f, 1, false), "money", 1.5f},
                {new InputArguments("tea", 1f, 2, true), "money", 1f},
                {new InputArguments("chocolate", 0.1f, 2, true), "money", 0.1f},
        };
    }

    @DataProvider
    public static Object[][] sugarInput() {
        return new Object[][]{
                {new InputArguments("coffee", 1.5f, 1, false), "sugar", 1},
                {new InputArguments("tea", 1f, 2, true), "sugar", 2},
                {new InputArguments("chocolate", 0.1f, 0, true), "sugar", 0},
        };
    }

    @DataProvider
    public static Object[][] extraHotInput() {
        return new Object[][]{
                {new InputArguments("coffee", 1.5f, 1, false), "extraHot", false},
                {new InputArguments("tea", 1f, 2, true), "extraHot", true},
                {new InputArguments("chocolate", 0.1f, 0, true), "extraHot", true},
        };
    }
}