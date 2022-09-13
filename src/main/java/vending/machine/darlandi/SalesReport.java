package vending.machine.darlandi;

import vending.machine.darlandi.output.CliOutput;
import vending.machine.darlandi.salesdatabase.FileDatabase;

import java.io.IOException;

public class SalesReport {

    public static void printSales(CliOutput out) {
        try {
            FileDatabase fileOperator = new FileDatabase();
            String filePath = fileOperator.FILE_PATH;
            String data = fileOperator.readAll(filePath);
            out.run(data);
        } catch (IOException e) {
            out.run(e.getMessage());
        }
    }

    public static void main(String[] args) {
        printSales(new CliOutput());
    }
}
