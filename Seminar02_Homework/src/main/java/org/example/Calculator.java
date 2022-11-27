package org.example;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;


public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Calculator.class.getName());
        FileHandler fh = new FileHandler("calcLog.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        int num1 = getNumber();
        logger.log(Level.INFO,"User entered number " + num1);
        int num2 = getNumber();
        logger.log(Level.INFO, "User entered number " + num2);
        char operation = getSign();
        logger.log(Level.INFO,"User entered operation " + operation);
        int result = calc(num1,num2,operation);
        logger.log(Level.INFO,"Result " + result);
        System.out.println("Result: " + result);
    }

    public static int getNumber(){
        System.out.println("Enter number:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();

        } else {
            System.out.println("Wrong input, try again!");
            scanner.next();
            num = getNumber();
        }
        return num;
    }

    public static char getSign(){
        System.out.println("Enter character:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Wrong input, try again!");
            scanner.next();
            operation = getSign();
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation){
        int result;
        switch (operation) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> result = num1 / num2;
            default -> {
                System.out.println("Fault, try again");
                result = calc(num1, num2, getSign());
            }
        }
        return result;
    }

}
