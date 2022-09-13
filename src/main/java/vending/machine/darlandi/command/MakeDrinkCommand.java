package vending.machine.darlandi.command;

import vending.machine.darlandi.drinks.*;
import vending.machine.darlandi.input.Input;
import vending.machine.darlandi.input.InputChecker;
import vending.machine.darlandi.messages.MessageBuilder;
import vending.machine.darlandi.salesdatabase.FileDatabase;
import vending.machine.darlandi.drinks.*;
import vending.machine.darlandi.output.Output;

public class MakeDrinkCommand implements Command {

    @Override
    public void execute(Input input, Output out) {
        final Drink[] ARRAY_DRINKS = {new Tea(), new Coffee(), new Chocolate()};

        try {
            new InputChecker().validateInput(input, ARRAY_DRINKS);
            out.run(MessageBuilder.getOrderString(input));
            new FileDatabase().add(DrinkFinder.getDrink(input, ARRAY_DRINKS));
        } catch (Exception e) {
            out.run(e.getMessage());
        }
    }
}
