package vending.machine.darlandi.messages;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import vending.machine.darlandi.input.Input;
import vending.machine.darlandi.input.InputArguments;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class MessageBuilderTest {

    @Test
    @UseDataProvider("argumentsInput")
    public void validateGetOrderString(Input input, String expectedOrderMessage) {
        String orderMessage = MessageBuilder.getOrderString(input);

        assertEquals(expectedOrderMessage, orderMessage);
    }

    @DataProvider
    public static Object[][] argumentsInput() {
        return new Object[][]{
                {new InputArguments("coffee", 1f, 1, false), "You have ordered a coffee with 1 sugars (stick included)"},
                {new InputArguments("tea", 1f, 2, true), "You have ordered a tea extra hot with 2 sugars (stick included)"},
                {new InputArguments("tea", 1f, 0, false), "You have ordered a tea with 0 sugar"},
                {new InputArguments("chocolate", 1f, 0, false), "You have ordered a chocolate with 0 sugar"},
                {new InputArguments("chocolate", 1f, 2, true), "You have ordered a chocolate extra hot with 2 sugars (stick included)"},
                {new InputArguments("coffee", 1f, 2, true), "You have ordered a coffee extra hot with 2 sugars (stick included)"},

        };
    }
}