package hw01;

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        System.out.println("Let the game begin!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter your name:");
        String name = scanner.nextLine();
        int number = (int) (Math.random() * 100);
        System.out.println("Guess the number between 0 and 100");
        int guess = 0;
        while (guess != number) {
            guess = scanner.nextInt();
            if (guess > number) {
                System.out.println("Your number is too big.Please, try again.");
            } else if (guess < number) {
                System.out.println("Your number is too small.Please, try again.");
            } else System.out.println("Congratulations, " + name + "!");
        }
    }
}
