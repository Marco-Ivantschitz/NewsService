package org.lecture;

import java.util.Scanner;

/**
 * In the Menu class the Menu will be created.
 * The correct input will also be proved
 */

public class Menu {

    Scanner scanner = new Scanner(System.in);

    public void menu() {
        String menu = """
                **********************************
                *                                *
                *          WELCOME To            *
                *                                *
                *         News Service           *
                *--------------------------------*
                *   (1) List Readers             *
                *--------------------------------*
                *   (2) Register Reader          *
                *   (3) Add Category for Reader  *
                *   (4) Deregister Reader        *
                *--------------------------------*
                *   (5) Update News List         *
                *--------------------------------*
                *   (6) Send News to Readers     *
                *   (7) Show News to all Readers *
                *--------------------------------*
                *   (8) Save Readers             *       
                *   (9) Load Readers             *
                *--------------------------------*
                *   (10) Exit Program            *
                *                                *
                **********************************
                """;

        System.out.println(menu);
    }

    public int consoleInput() {
        while (true) {
            try {
                System.out.print("Bitte wählen Sie eine Zahl: ");
                int eingabe = Integer.parseInt(scanner.nextLine());
                if (eingabe < 1 || eingabe > 10) {
                    System.out.println("Einagbe fehlerhaft");
                    menu();
                    continue;
                }
                return eingabe;

            } catch (Exception e) {
                System.out.println("Einagbe fehlerhaft");
                menu();
                continue;
            }
        }
    }

}
