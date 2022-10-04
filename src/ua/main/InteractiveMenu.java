package ua.main;

import java.util.Scanner;

public class InteractiveMenu {

    private static String choiceFileConsole() {
        System.out.println("File (1) or console (2)? (write number)");
        Scanner sc = new Scanner(System.in);
        String string;
        while (true) {
            String number = sc.nextLine();
            if(number.equals("1")) {
                System.out.print("Enter your string: ");
                string = sc.nextLine();
                break;
            } else if(number.equals("2")) {
                System.out.println("Ukrainian(1), English(2) or German(3)?");
                while (true) {
                    String variant = sc.nextLine();
                    if(variant.equals("1")) {
                        string = "/Users/olenababiy/labs/TIK_lab1/src/ua/main/files/ua.txt";
                        break;
                    }
                    else if(variant.equals("2")) {
                        string = "/Users/olenababiy/labs/TIK_lab1/src/ua/main/files/en.txt";
                        break;
                    }
                    else if(variant.equals("3")) {
                        string = "/Users/olenababiy/labs/TIK_lab1/src/ua/main/files/de.txt";
                        break;
                    }
                    else
                        System.out.println("Try again");
                }

                break;
            } else
                System.out.println("Try again");
        }
        return string;
    }

    public static void results() {
        String string = choiceFileConsole();
        ManagerSymbols symbolCounter = new ManagerSymbols(string);
        System.out.println("Entropy: " + symbolCounter.getEntropy());
        System.out.println("Average entropy of symbol: " + symbolCounter.getAverageEntropy());
        System.out.println("Amount of information: " + symbolCounter.getAmountInformation());
        System.out.println("Max entropy: " + symbolCounter.getMaxEntropy());
        System.out.println("Absolute excess: " + symbolCounter.getAbsoluteExcess());
        System.out.println("Relative excess: " + symbolCounter.getRelativeExcess());
    }
}
