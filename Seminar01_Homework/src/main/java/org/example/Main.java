package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Factorial:" + factorial(5));
        SimpleNumbers(1000);
        TaskWithStar();

    }

    public static Integer factorial(int n){
        if (n == 1){
            return n;
        }
        else {
            return factorial(n - 1) * n;
        }
    }

    public static void SimpleNumbers(int n){
        for (int i = 3; i < n; i++){
            int num = 2;
            while (num <= Math.sqrt(i)){
                if (i % num == 0){
                    break;
                }
                else{
                    num++;
                    if (num > Math.sqrt(i)){
                        System.out.println(i);
                    }
                }
            }
        }
    }

    public static void TaskWithStar(){
        String equation = "2?+?5=69";
        System.out.println(equation);
        String[] arr = equation.split("[\\+\\=]");
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                int num1 = Integer.parseInt(arr[0].replace("?", Integer.toString(i)));
                int num2 = Integer.parseInt(arr[1].replace("?", Integer.toString(j)));
                int result = Integer.parseInt(arr[2]);
                if (num1 + num2 == result){
                    String res = Integer.toString(num1) + "+" + Integer.toString(num2) + "=" + arr[2];
                    System.out.println("Result:" + res);
                }


            }
        }
    }


}