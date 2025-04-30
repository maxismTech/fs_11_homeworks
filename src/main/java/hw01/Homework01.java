package hw01;

import java.util.Scanner;
import java.util.Arrays;

public class Homework01 {
    public static void main(String[] args) {

        System.out.println("Let the game begin!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter your name:");
        String name = scanner.nextLine();

        // Рандомне число від 0 до 100
        int number = (int) (Math.random() * 100);
        System.out.println("Guess the number between 0 and 100");

        // Масив для збереження здогадок
        int[] guesses = new int[20];
        int guess = -100;
        int attempts = 0;

        do {
            if (scanner.hasNextInt())  {
            guess = scanner.nextInt(); // Зчитуємо здогадку
            guesses[attempts] = guess; // Зберігаємо здогадку у масив
            attempts++; // Збільшуємо лічильник

            if (guess > number) {
                System.out.println("Your number is too big. Please, try again.");
            } else if (guess < number) {
                System.out.println("Your number is too small. Please, try again.");
            }
            } else {
                System.out.println("That's not a valid number. Please enter an integer.");
                scanner.next(); // Зчитуємо ввід, щоб не застрягти в нескінченному циклі
            }
        } while (guess != number);

        System.out.println("Congratulations, " + name + "!");

        // Виведення всіх здогадок
        int[] validGuesses = Arrays.copyOf(guesses, attempts);
        Arrays.sort(validGuesses);
        System.out.println("Your numbers:");

        for (int i = attempts - 1; i != -1; i--) {
            System.out.print(validGuesses[i] + " ");
        }

    }
}

