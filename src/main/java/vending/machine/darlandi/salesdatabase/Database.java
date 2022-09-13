package vending.machine.darlandi.salesdatabase;

import vending.machine.darlandi.drinks.Drink;

import java.io.IOException;

public interface Database {
    boolean createDatabase() throws IOException;

    String readAll(String filePath) throws IOException;

    boolean add(Drink drink) throws IOException;
}
