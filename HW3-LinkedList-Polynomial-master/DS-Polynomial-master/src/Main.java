import java.lang.invoke.SwitchPoint;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String []args){

        int choice = -1,
                polyChoice = -1,
                editAction = -1;


        Scanner keyboard = new Scanner(System.in);

        Term sampleTerm = new Term("+x");
        Term sampleTerm2 = new Term("5x^2");
        Term sampleTerm3 = new Term("3x^3");
        Term sampleTerm4 = new Term("-6x");

        Polynomial firstPolynomial = new Polynomial();
        Polynomial secondPolynomial = new Polynomial();

        firstPolynomial.addTerm(sampleTerm);
        firstPolynomial.addTerm(sampleTerm2);
        secondPolynomial.addTerm(sampleTerm3);
        secondPolynomial.addTerm(sampleTerm4);

        do {
            // Display Polynomials and Menu
            System.out.println("\nPolynomial Program w/ Linked Lists");
            System.out.println("Polynomial 1: " + firstPolynomial);
            System.out.println("Polynomial 2: " + secondPolynomial);

            System.out.println("Choose an action (1-4)");
            System.out.println("1) Edit first Polynomial");
            System.out.println("2) Edit second Polynomial");
            System.out.println("3) Add the two Polynomials");
            System.out.println("4) Quit program");

            // Read in user choice
            choice = keyboard.nextInt();

            // Error Check user input
            while (choice < 1 || choice >4)
            {
                System.out.println("Error, please enter a value between (1-4)");
                choice = keyboard.nextInt();
            }

            switch(choice)
            {
                case 1:
                    polyChoice = 1;
                    break;
                case 2:
                    polyChoice = 2;
                    break;
                case 3:
                    // Creates a temporary polynomial to store the first polynomial,
                    // while the first and second are added together and stored in the first polynomial
                    Polynomial copyPolynomial = new Polynomial();
                    copyPolynomial.add(firstPolynomial);
                    firstPolynomial.add(secondPolynomial);
                    System.out.println("The Polynomials added together: " + firstPolynomial);
                    firstPolynomial.clear();
                    firstPolynomial.add(copyPolynomial);
                    copyPolynomial.clear();
                    polyChoice = -1;

                    break;
                case 4:
                    // End Program
                    System.out.println("Ending Polynomial Program.");
                    System.exit(0);
                    break;
            }

            if (polyChoice != -1)
            {
                Polynomial copyPolynomial = new Polynomial();

                 // Menu for Polynomial edit actions
                System.out.println("Choose an action for Polynomial " + polyChoice + " (1-4)");
                System.out.println("1) Clear Polynomial");
                System.out.println("2) Create Polynomial");
                System.out.println("3) Add Terms");
                System.out.println("4) Cancel");

                editAction = keyboard.nextInt();

                // Error Check user input
                while (editAction < 1 || editAction >4)
                {
                    System.out.println("Error, please enter a value between (1-4)");
                    editAction = keyboard.nextInt();
                }

                switch(editAction)
                {
                    case 1:
                        // Clear first or second Polynomial and display cleared message
                        if (polyChoice == 1)
                            firstPolynomial.clear();
                        if (polyChoice == 2)
                            secondPolynomial.clear();
                        System.out.println("Polynomial " + polyChoice + " cleared.");
                        break;
                    case 2:

                        break;
                    case 3:
                        // Prompt for term, then add term to the temp Polynomial, then add to first or second Polynomial
                        System.out.print("Enter Term to add: " );
                        copyPolynomial.addTerm(new Term(keyboard.next()));

                        if (polyChoice == 1)
                            firstPolynomial.add(copyPolynomial);
                        else
                            secondPolynomial.add(copyPolynomial);

                        break;
                    case 4:
                        // Cancel Polynomial edit
                        System.out.println("Canceling..");
                        break;
                }
            }

        } while (true);

    }

}
