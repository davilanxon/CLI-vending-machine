package vending.machine.darlandi.input;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import vending.machine.darlandi.drinks.Coffee;
import vending.machine.darlandi.drinks.Drink;
import vending.machine.darlandi.exceptions.InputException;
import vending.machine.darlandi.messages.MessagesException;
import vending.machine.darlandi.drinks.Chocolate;
import vending.machine.darlandi.drinks.Tea;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class InputCheckerTest {
    private final Drink[] ARRAY_DRINKS = {new Tea(), new Coffee(), new Chocolate()};

    @Test
    @UseDataProvider("trueInput")
    public void validateInputWithGoodValues(Input input) throws InputException {
        Boolean result = new InputChecker().validateInput(input, ARRAY_DRINKS);
        assertEquals(true, result);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    @UseDataProvider("falseInput")
    public void validateInputWithBadValues(Input input, String message) throws InputException {
        exceptionRule.expect(InputException.class);
        exceptionRule.expectMessage(message);
        new InputChecker().validateInput(input, ARRAY_DRINKS);
    }

    @DataProvider
    public static Object[][] trueInput() {
        return new Object[][]{
                {new InputArguments("coffee", 0.5f, 1, false)},
                {new InputArguments("coffee", 1f, 1, true)},
                {new InputArguments("tea", 0.4f, 2, true)},
                {new InputArguments("tea", 1f, 0, false)},
                {new InputArguments("chocolate", 1f, 0, false)},
                {new InputArguments("chocolate", 0.6f, 2, true)},
        };
    }

    @DataProvider
    public static Object[][] falseInput() {
        return new Object[][]{
                {new InputArguments("coffe", 0.6f, 20, true), MessagesException.INCORRECT_DRINK_TYPE},
                {new InputArguments("coffee", -1f, 0, false), String.format(MessagesException.INCORRECT_MONEY, "coffee", 0.5f)},
                {new InputArguments("tea", 0.1f, 2, true), String.format(MessagesException.INCORRECT_MONEY, "tea", 0.4f)},
                {new InputArguments("teaae", 0.1f, 2, true), MessagesException.INCORRECT_DRINK_TYPE},
                {new InputArguments("chocolate", 0.7f, -1, false), MessagesException.INCORRECT_SUGAR},
        };
    }
}