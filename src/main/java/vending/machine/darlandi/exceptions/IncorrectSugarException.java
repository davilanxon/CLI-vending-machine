package vending.machine.darlandi.exceptions;

import vending.machine.darlandi.messages.MessagesException;

public class IncorrectSugarException extends InputException {
    public IncorrectSugarException() {
        super(MessagesException.INCORRECT_SUGAR);
    }
}
