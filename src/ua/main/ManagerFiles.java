package ua.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ManagerFiles {
    public String getFileData(String fileName) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            result.append(scanner.nextLine());
        }
        return String.valueOf(result);
    }


}
