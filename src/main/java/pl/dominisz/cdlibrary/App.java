package pl.dominisz.cdlibrary;

import pl.dominisz.cdlibrary.menu.CDDisplay;
import pl.dominisz.cdlibrary.menu.CDReader;

import java.awt.*;
import java.util.Scanner;

/**
 * http://dominisz.pl
 * 25.03.2018
 */
public class App {

    private CDLibrary cdLibrary = new CDLibrary();
    private Scanner scanner = new Scanner(System.in);
    private CDReader newCD = new CDReader(cdLibrary, scanner);

    public void showMainMenu() {
        cdLibrary.loadFromFile();
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add new CD");
            System.out.println("2. Show all CDs");
            System.out.println("3. Exit");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    newCD.addNewCD();
                    break;
                case 2:
                    CDDisplay.show(cdLibrary.getCDs());
                    break;
                default:
                    exit = true;
            }
        }
        cdLibrary.saveToFile();
    }

    public static void main(String[] args) {
        App app = new App();
        app.showMainMenu();
    }

}
