package oops4;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 2055);
            ArithmeticInterface stub = (ArithmeticInterface) reg.lookup("ArithmeticService");

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter first number: ");
            double a = sc.nextDouble();
            System.out.println("Enter second number: ");
            double b = sc.nextDouble();

            System.out.println("Choose operation: +  -  *  /");
            char op = sc.next().charAt(0);

            double result = 0;
            switch (op) {
                case '+': result = stub.add(a, b); break;
                case '-': result = stub.subtract(a, b); break;
                case '*': result = stub.multiply(a, b); break;
                case '/': result = stub.divide(a, b); break;
                default:
                    System.out.println("Invalid operation!");
                    return;
            }

            System.out.println("Result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
