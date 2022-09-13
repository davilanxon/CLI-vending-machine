package vending.machine.darlandi.input;

import vending.machine.darlandi.drinks.Drink;
import vending.machine.darlandi.drinks.DrinkFinder;
import vending.machine.darlandi.exceptions.IncorrectDrinkTypeException;
import vending.machine.darlandi.exceptions.IncorrectSugarException;
import vending.machine.darlandi.exceptions.InputException;
import vending.machine.darlandi.exceptions.IncorrectMoneyException;

public class InputChecker {
    private Drink drink;
    private Float money;
    private int sugarsNo;
    private static final int MIN_SUGAR = 0;
    private static final int MAX_SUGAR = 2;

    public boolean validateInput(Input input, Drink[] arrayDrinks) throws InputException {
        loadParameters(input);
        if (!validateDrink(input, arrayDrinks)) {
            throw new IncorrectDrinkTypeException();
        }
        if (!validateMoney(this.drink, this.money)) {
            throw new IncorrectMoneyException(drink.name(), drink.price());
        }
        if (!validateSugar(this.sugarsNo)) {
            throw new IncorrectSugarException();
        }
        return true;
    }

    private void loadParameters(Input input) {
        this.money = input.getParameter("money");
        this.sugarsNo = input.getParameter("sugar");
    }

    private boolean validateDrink(Input input, Drink[] arrayDrink) {
        boolean drinkFound = true;

        this.drink = DrinkFinder.getDrink(input, arrayDrink);
        if (drink == null) {
            drinkFound = false;
        }
        return drinkFound;
    }

    private boolean validateMoney(Drink drink, Float money) {
        return (money >= drink.price());
    }

    private boolean validateSugar(int sugarAmount) {
        return (sugarAmount >= MIN_SUGAR && sugarAmount <= MAX_SUGAR);
    }
}
