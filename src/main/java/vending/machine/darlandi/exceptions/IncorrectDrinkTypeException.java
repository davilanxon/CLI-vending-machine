package vending.machine.darlandi.exceptions;

import vending.machine.darlandi.messages.MessagesException;

public class IncorrectDrinkTypeException extends InputException {

    public IncorrectDrinkTypeException() {
        super(MessagesException.INCORRECT_DRINK_TYPE);
    }
}
