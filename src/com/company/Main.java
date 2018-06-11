package com.company;

/*
    Dates are fun to work with in Java 8!
 
Look at this example to see how easy working with dates can be:
https://github.com/aoa4eva/DateTimeExampleJ8
 
Now, modify that exercise to make it show the following:
- The date entered in day, Month (3 letters) and year (4 digit) format
- The date entered in Month (3 letters), day  and year (4 digit) format
- The date entered in day, month (2 digits) and year format
Add output before each line to explain the format the user is looking at.
 
If the date the user enters is after today,
  the program should loop until the user enters a date on or before today.
 
If the date the user enters  is NOT in dd/mm/yyyy format,
   the user should be prompted to re-enter the date.

*/


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner keyboard = new Scanner(System.in);

        //Get the current time
        LocalDateTime rightNow = LocalDateTime.now();

        //Date from the user
        String aDate;
        LocalDate userDate = null;

        //Set up formatters so that we can use them later
        DateTimeFormatter shortMonthFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        DateTimeFormatter shortMonthFormat2 = DateTimeFormatter.ofPattern("MMM dd yyyy");
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Prompt the user for a date in the dd/mm/yyyy format again if the user fails to do so and get it
        try {
            // Prompt the user for a date and get it
            System.out.print("Enter a date (dd/MM/yyyy): ");
            aDate = keyboard.nextLine();
            // Convert String date to LocalDate date in dd/MM/yyyy format
            userDate = LocalDate.parse(aDate, dTF);
        } catch (DateTimeParseException e) {
            System.out.print("Wrong format.\nTry re-entering a date in dd/MM/yyyy format (ex. 01/01/2018): ");
            aDate = keyboard.nextLine();
            // Convert String date to LocalDate date in dd/MM/yyyy format
            userDate = LocalDate.parse(aDate, dTF);
        }

        // If user enters a date after today, prompt the user for a date on or before today and get it
        while (userDate.compareTo(rightNow.toLocalDate()) > 0) {
            System.out.println("Enter a date on or before today: ");
            try {
                aDate = keyboard.nextLine();
                // Convert String date to LocalDate date in dd/MM/yyyy format
                userDate = LocalDate.parse(aDate, dTF);
            } catch (DateTimeParseException e) {
                System.out.print("Wrong format.\nTry re-entering a date in dd/MM/yyyy format (ex. 01/01/2018): ");
                aDate = keyboard.nextLine();
                // Convert String date to LocalDate date in dd/MM/yyyy format
                userDate = LocalDate.parse(aDate, dTF);
            }
        }

        // Display the date entered by the user in three different formats
        System.out.println("\nThe date entered in day, Month (3 letters) " +
                "and year (4 digit) format:" + "\n    " + userDate.format(shortMonthFormat));
        System.out.println("The date entered in Month (3 letters), day  " +
                "and year (4 digit) format:" + "\n    " + userDate.format(shortMonthFormat2));
        System.out.println("The date entered in day, month " +
                "(2 digits) and year format:" + "\n    " + userDate.format(dTF));

    }
}
