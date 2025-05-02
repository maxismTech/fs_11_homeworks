package hw03;

import java.util.Scanner;

public class Homework03 {


    public static class WeeklyPlanner {
        public static void main(String[] args) {
            String[][] schedule = new String[7][2];
            schedule[0][0] = "Sunday";
            schedule[0][1] = "do home work";
            schedule[1][0] = "Monday";
            schedule[1][1] = "go to courses; watch a film";
            schedule[2][0] = "Tuesday";
            schedule[2][1] = "play video games";
            schedule[3][0] = "Wednesday";
            schedule[3][1] = "go on a date";
            schedule[4][0] = "Thursday";
            schedule[4][1] = "go to the gym";
            schedule[5][0] = "Friday";
            schedule[5][1] = "hard work before weekends";
            schedule[6][0] = "Saturday";
            schedule[6][1] = "have fun";

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Please, input the day of the week:");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                }

                String normalizedInput = input.toLowerCase();

                boolean found = false;
                for (String[] strings : schedule) {
                    if (strings[0].toLowerCase().equals(normalizedInput)) {
                        System.out.println("Your tasks for " + strings[0] + ": " + strings[1] + ".");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Sorry, I don't understand you, please try again.");
                }
            }

            scanner.close();
        }
    }

}
