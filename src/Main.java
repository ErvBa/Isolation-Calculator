
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    private static Calculator calc;
    public static void main(String [] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            calc = new Calculator();
            Scanner scan = new Scanner(System.in);

            WindowCreator window = new WindowCreator();
       /* System.out.println("Type in height");

        calc.setExpectedThickness(scan.nextInt());

        System.out.println("type in area");
        calc.setExpectedArea(scan.nextInt());

        printCost();
        printAverageConsuption();
        */
        }
    });
    }



    private static void printCost() {
        System.out.println();
        System.out.println();
        System.out.print("Cost is ");
        System.out.print(calc.calculateCost());
        System.out.println("kr.");

    }
    private static void printAverageConsuption() {
        System.out.print("Expected consumption ");
        System.out.print(calc.averageMaterialConsumption());
        System.out.println("l.");
        System.out.println();
    }
}
