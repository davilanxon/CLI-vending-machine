package vending.machine.darlandi.salesdatabase;

import vending.machine.darlandi.drinks.Drink;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDatabase implements Database {
    private final String DIR_NAME = ".sales";
    public final String FILE_PATH = DIR_NAME + "/total-sales.txt";
    private final String FIRST_DATA = "DRINK      |      MONEY\n"
            + "------------------------\n"
            + "TEA        |      0.0\n"
            + "COFFEE     |      0.0\n"
            + "CHOCOLATE  |      0.0";

    public FileDatabase() throws IOException {
        createDatabase();
    }

    public boolean createDatabase() throws IOException {
        File salesFile = new File(FILE_PATH);
        File directory = new File(DIR_NAME);

        if (!directory.exists()) {
            directory.mkdir();
        }
        if (!salesFile.exists()) {
            if (salesFile.createNewFile()) {
                saveInFile(FIRST_DATA);
            }
        }
        return true;
    }

    public boolean add(Drink drink) throws IOException {
        String data = readAll(this.FILE_PATH);
        if (data.toLowerCase().contains(drink.name())) {
            String newData = searchAndReplaceMoney(data, drink);
            saveInFile(newData);
            return true;
        }
        return false;
    }

    public String readAll(String filePath) throws IOException {
        Scanner sc = new Scanner(new java.io.File(filePath));
        StringBuilder fileData = new StringBuilder();

        while (sc.hasNextLine()) {
            fileData.append(sc.nextLine()).append(System.lineSeparator());
        }
        return fileData.toString();
    }

    private boolean saveInFile(String msg) throws IOException {
        FileWriter myWriter = new FileWriter(FILE_PATH);

        myWriter.write(msg);
        myWriter.close();
        return true;
    }

    private String searchAndReplaceMoney(String data, Drink drink) {
        int beginIndex = data.toLowerCase().indexOf(drink.name());
        int endIndex = data.indexOf("\n", beginIndex);
        String oldLine = data.substring(beginIndex, endIndex);
        Float oldAmount = getNumber(oldLine) / 10.0f;
        String newTotalAmount = String.format("%.1f", oldAmount + drink.price());
        String newLine = oldLine.replaceAll(oldAmount.toString(), newTotalAmount);
        return data.replace(oldLine, newLine);
    }

    private Long getNumber(String line) {
        char[] chars = line.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c : chars) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return Long.parseLong(sb.toString());
    }
}
