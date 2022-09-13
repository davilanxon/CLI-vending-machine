package vending.machine.darlandi.messages;

import vending.machine.darlandi.input.Input;

public class MessageBuilder {
    public static String getOrderString(Input input) {
        StringBuilder message = new StringBuilder();
        int sugarsNo = input.getParameter("sugar");
        Boolean isExtraHot = input.getParameter("extraHot");
        String drinkType = input.getParameter("drinkType");

        message = message.append(DrinkMessages.ORDER_MESSAGE + drinkType);
        if (isExtraHot) {
            message = message.append(DrinkMessages.EXTRA_HOT);
        }
        if (sugarsNo > 0) {
            message = message.append(String.format(DrinkMessages.WITH_SUGAR, sugarsNo));
        } else {
            message = message.append(String.format(DrinkMessages.NO_SUGAR, sugarsNo));
        }
        return message.toString();
    }
}
