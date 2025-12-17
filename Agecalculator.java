import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class AgeCalculator {

    public static void main(String[] args) {
        // 1. Setup scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Java Age Calculator ---");

        try {
            // 2. Ask for user input (Year, Month, Day)
            System.out.print("Enter your birth year (YYYY): ");
            int year = scanner.nextInt();

            System.out.print("Enter your birth month (1-12): ");
            int month = scanner.nextInt();

            System.out.print("Enter your birth day (1-31): ");
            int day = scanner.nextInt();

            // 3. Create the LocalDate objects
            LocalDate birthDate = LocalDate.of(year, month, day);
            LocalDate currentDate = LocalDate.now(); // Gets today's date from system

            // 4. Validate if birthDate is in the future
            if ((birthDate != null) && (currentDate != null)) {
                if(birthDate.isAfter(currentDate)) {
                    System.out.println("Error: Birth date cannot be in the future!");
                } else {
                    // 5. Calculate the period between the two dates
                    Period period = Period.between(birthDate, currentDate);

                    // 6. Display the result
                    System.out.println("\n--- Your Age ---");
                    System.out.println("Years:  " + period.getYears());
                    System.out.println("Months: " + period.getMonths());
                    System.out.println("Days:   " + period.getDays());
                }
            }

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter numbers only.");
        } finally {
            // Close scanner to prevent resource leaks
            scanner.close();
        }
    }
}
