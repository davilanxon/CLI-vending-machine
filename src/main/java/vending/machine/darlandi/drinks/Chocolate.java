package vending.machine.darlandi.drinks;

public class Chocolate implements Drink {
    @Override
    public Float price() {
        return 0.6f;
    }

    @Override
    public String name() {
        return "chocolate";
    }
}
