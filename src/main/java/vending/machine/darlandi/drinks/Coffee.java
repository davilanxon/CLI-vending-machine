package vending.machine.darlandi.drinks;

public class Coffee implements Drink {
    @Override
    public Float price() {
        return 0.5f;
    }

    @Override
    public String name() {
        return "coffee";
    }
}
