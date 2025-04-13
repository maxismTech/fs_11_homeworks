package hw01;

import java.util.Scanner;

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
        int[] guesses = new int[10];
        int guess;
        int attempts = 0;

        do {
            guess = scanner.nextInt(); // Зчитуємо здогадку
            guesses[attempts] = guess; // Зберігаємо здогадку у масив
            attempts++; // Збільшуємо лічильник

            if (guess > number) {
                System.out.println("Your number is too big. Please, try again.");
            } else if (guess < number) {
                System.out.println("Your number is too small. Please, try again.");
            }
        } while (guess != number);

        System.out.println("Congratulations, " + name + "!");

        // Виведення всіх здогадок
        System.out.println("Your guesses were:");
        for (int i = 0; i < attempts; i++) {
            System.out.print(guesses[i] + " ");
        }
    }
}

