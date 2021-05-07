
import java.util.Scanner;

public class Main {
    private static Calculator calc;
    public static void main(String [] args) {
        calc = new Calculator();
        Scanner scan = new Scanner(System.in);

        System.out.println("Type in height");

        calc.setExpectedHeight(scan.nextInt());

        System.out.println("type in area");
        calc.setExpectedArea(scan.nextInt());

        printCost();
    }

    private static void printCost() {
        System.out.print("Cost is ");
        System.out.print(calc.calculateCost());
        System.out.println("kr.");
    }
}
