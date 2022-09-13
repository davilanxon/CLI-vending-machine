package vending.machine.darlandi.command;

import vending.machine.darlandi.input.Input;
import vending.machine.darlandi.output.Output;

public interface Command {

    void execute(Input input, Output out);
}
