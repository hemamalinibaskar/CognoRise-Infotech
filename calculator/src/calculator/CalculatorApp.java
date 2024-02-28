package calculator;

//import packages
import java.util.Scanner;

//Define CalculatorApp class
public class CalculatorApp {
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in); // Scanner object
        double result = 0; // Variable Initialization 

        boolean exit = false; // default value exit -> false
        while (!exit) { // Loop until the user chooses to exit
        	
        	// Display the welcome message and calculator menu
        	System.out.println("");
        	System.out.println("   WELCOME TO THE CALCULATION OF LIFE   ");
        	System.out.println("          --------------------          ");
            System.out.println("          | Calculator Menu: |          ");
            System.out.println("          --------------------          ");
            System.out.println("");
            System.out.println("----------------------------------------");
            System.out.println("| OPERATOR |        DESCRIPTION        |");
            System.out.println("----------------------------------------");
            System.out.println("|    +     |          ADDITION         |");
            System.out.println("|    -     |        SUBTRACTION        |");
            System.out.println("|    *     |       MULTIPLICATION      |");
            System.out.println("|    /     |          DIVISION         |");
            System.out.println("|    =     |   To Calculate the RESULT |");
            System.out.println("----------------------------------------");
            System.out.println("|   exit   |          To EXIT          |");
            System.out.println("|  0 to 9  |          NUMBERS          |");
            System.out.println("----------------------------------------");
            System.out.println("");
            
            System.out.print("Enter the INPUT: ");
            String input = scanner.nextLine().trim(); // Read user input and removes the White spaces

            if (input.equals("=")) { // Check if user wants to calculate the result
                if (result == 0) {
                    System.out.println("\nResult: 0.0");
                } else {
                    System.out.println("\nResult: " + result);
                }
                continue; // Continue to the next iteration 
            } else if (input.equalsIgnoreCase("exit")) { // Check if user wants to exit
                System.out.println("\nCalculator Exited...");
                break; // Exit the loop
            }

            try {
                double number = Double.parseDouble(input); // Convert input to double

                while (true) { // Inner loop 
                    System.out.print("\nEnter the Operator (+, -, *, /) OR '=' to calculate the Result: ");
                    String operatorInput = scanner.nextLine().trim(); 

                    if (operatorInput.equals("=")) { // Check if user wants to calculate the result
                        result = number; // Store the result
                        System.out.println("\nResult: " + result);
                        break; 
                    } else if (operatorInput.equalsIgnoreCase("exit")) { // Check if user wants to exit
                        System.out.println("Calculator Exited...");
                        exit = true; // Set exit to true to exit the outer loop
                        break; 
                    }

                    if (operatorInput.length() != 1 || "+-*/".indexOf(operatorInput.charAt(0)) == -1) {
                        System.out.println("\nInvalid Operator."); // Notify user of invalid operator
                        continue; 
                    }

                    char operator = operatorInput.charAt(0); 

                    System.out.print("\nEnter Next Number: ");
                    double nextNumber;
                    try {
                        nextNumber = Double.parseDouble(scanner.nextLine().trim()); 
                    } catch (NumberFormatException e) {
                        System.out.println("\nError: Invalid input. Please Enter a Valid Input.");
                        continue;
                    }

                    switch (operator) { // Switch case
                        case '+':
                            result = number + nextNumber;
                            break;
                        case '-':
                            result = number - nextNumber;
                            break;
                        case '*':
                            result = number * nextNumber;
                            break;
                        case '/':
                            if (nextNumber == 0) { // Check for division by zero
                                System.out.println("\nError: Cannot divide by zero");
                                continue; 
                            }
                            result = number / nextNumber;
                            break;
                        default:
                            System.out.println("\nInvalid Operator."); // Notify user of invalid operator
                            continue; 
                    }
                    number = result; // Update the current number for subsequent calculations
                }
            } catch (NumberFormatException e) {
                System.out.println("\nError: Invalid input. Please Enter a Valid Input."); // Notify user of invalid input
            }
        }
        System.out.println("Numbers may fade, but the math continues. Farewell for now!!!");
        scanner.close(); // Close the scanner 
    }
}
