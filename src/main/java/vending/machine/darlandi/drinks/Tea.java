package vending.machine.darlandi.drinks;

public class Tea implements Drink {
    @Override
    public Float price() {
        return 0.4f;
    }

    @Override
    public String name() {
        return "tea";
    }
}
