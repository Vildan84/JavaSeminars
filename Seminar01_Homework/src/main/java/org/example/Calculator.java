package org.example;

import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int num1 = getNumber();
        int num2 = getNumber();
        char operation = getSign();
        int result = calc(num1,num2,operation);
        System.out.println("Result: "+result);
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
