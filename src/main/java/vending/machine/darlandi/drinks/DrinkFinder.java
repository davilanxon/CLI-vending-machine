package vending.machine.darlandi.drinks;

import vending.machine.darlandi.input.Input;

public class DrinkFinder {
    public static Drink getDrink(Input input, Drink[] arrayDrink) {
        String drinkType = input.getParameter("drinkType");

        for (Drink drink : arrayDrink) {
            if (drinkType.equals(drink.name())) {
                return drink;
            }
        }
        return null;
    }
}
