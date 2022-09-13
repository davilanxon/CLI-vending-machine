package vending.machine.darlandi.exceptions;

import vending.machine.darlandi.messages.MessagesException;

public class IncorrectMoneyException extends InputException {
    public IncorrectMoneyException(String name, Float price) {
        super(String.format(MessagesException.INCORRECT_MONEY, name, price));
    }
}
