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
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        //Get the current time
        LocalDateTime rightNow = LocalDateTime.now();

        //Date from the user
        LocalDate userDate = null;

        //Set up formatters so that you can use them later
        DateTimeFormatter shortMonthFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        DateTimeFormatter shortMonthFormat2 = DateTimeFormatter.ofPattern("MMM dd yyyy");
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Time formatter (time only)
        DateTimeFormatter hr24 = DateTimeFormatter.ofPattern("kk:m");

        // Prompt the user for
        System.out.print("Enter a date (dd/MM/yyyy): ");
        String aDate = keyboard.nextLine();
        userDate = LocalDate.parse(aDate, dTF);

        while (userDate.compareTo(rightNow.toLocalDate()) > 0) {
            System.out.println("Enter a date before today or today's date: ");
            aDate = keyboard.nextLine();
            userDate = LocalDate.parse(aDate, dTF);
        }

        System.out.println();
        System.out.println("The date entered in day, Month (3 letters) " +
                "and year (4 digit) format:" + "\n    " + userDate.format(shortMonthFormat));
        System.out.println("The date entered in Month (3 letters), day  " +
                "and year (4 digit) format:" + "\n    " + userDate.format(shortMonthFormat2));
        System.out.println("The date entered in day, month " +
                "(2 digits) and year format:" + "\n    " + userDate.format(dTF));

    }
}