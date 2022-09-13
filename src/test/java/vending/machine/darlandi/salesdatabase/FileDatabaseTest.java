package vending.machine.darlandi.salesdatabase;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import vending.machine.darlandi.drinks.Coffee;
import vending.machine.darlandi.drinks.Drink;
import vending.machine.darlandi.drinks.Chocolate;
import vending.machine.darlandi.drinks.Tea;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class FileDatabaseTest {
    private static FileDatabase fileDatabase;

    @BeforeClass
    public static void beforeClass() throws Exception {
        fileDatabase = new FileDatabase();
        fileDatabase.createDatabase();
    }

    @Test
    public void validateCreateNewFileOrFileAlreadyExists() throws IOException {
        boolean result = fileDatabase.createDatabase();
        assertTrue(result);
    }

    @Test
    @UseDataProvider("drinks")
    public void validateAddToDatabase(Drink drink) throws IOException {
        boolean result = fileDatabase.add(drink);
        assertTrue(result);
    }

    @Test
    public void validateReadFile() throws IOException {
        String filePath = fileDatabase.FILE_PATH;

        String data = fileDatabase.readAll(filePath);
        boolean result = data.contains("DRINK      |      MONEY\n"
                + "------------------------\n");
        assertTrue(result);
    }

    @DataProvider
    public static Object[][] drinks() {
        return new Object[][]{
                {new Chocolate()},
                {new Coffee()},
                {new Tea()},
        };
    }
}