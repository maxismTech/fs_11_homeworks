package hw02;

import java.util.Scanner;


public class Homework02 {

        public static void main(String[] args) {
           final int SIZE = 5;
            char[][] field = new char[SIZE][SIZE];

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    field[i][j] = '-';
                }
            }

            int targetRow = (int) (Math.random() * SIZE);
            int targetCol = (int) (Math.random() * SIZE);

            System.out.println("All Set. Get ready to rumble!");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                int row = getValidInput(scanner, "Enter row (1-5): ", SIZE);
                int col = getValidInput(scanner, "Enter column (1-5): ", SIZE);

                if (field[row - 1][col - 1] == '*' || field[row - 1][col - 1] == 'x') {
                    System.out.println("You've already shot there! Try another cell.");
                    continue;
                }

                if ((row - 1) == targetRow && (col - 1) == targetCol) {
                    field[row - 1][col - 1] = 'x';
                    printField(field);
                    System.out.println("You have won!");
                    break;
                } else {
                    field[row - 1][col - 1] = '*';
                    printField(field);
                }
            }
        }

        private static int getValidInput(Scanner scanner, String prompt, int size) {
            int input;
            while (true) {
                System.out.print(prompt);
                if (scanner.hasNextInt()) {
                    input = scanner.nextInt();
                    if (input >= 1 && input <= size) {
                        return input;
                    } else {
                        System.out.println("Number must be between 1 and " + size + ".");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
            }
        }

        private static void printField(char[][] field) {
            System.out.print("  ");
            for (int i = 1; i <= field.length; i++) {
                System.out.print("| " + i + " ");
            }
            System.out.println("|");

            for (int i = 0; i < field.length; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < field[i].length; j++) {
                    System.out.print("| " + field[i][j] + " ");
                }
                System.out.println("|");
            }
        }

}
