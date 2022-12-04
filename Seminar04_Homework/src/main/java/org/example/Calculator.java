package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static boolean flag = true;
    static HashMap<String, String> map = new HashMap<>();
    static Stack<String> st = new Stack<>();
    static double result;

    public static void main(String[] args) {

        System.out.println("Welcome to calculator!!!\nTo Quit enter: exit\nTo delete previous number, enter: '<'");
        while(flag) {

            getNumber();
            System.out.println("= " + calc());

        }
    }

    public static void getNumber() {

        System.out.println("Enter:");
        String str = scanner.nextLine();
        str = str.replace(" ", "");

        if (str.equals("<")){
            map.put("num1", st.get(st.size() - 2));
            System.out.println("= " + map.get("num1"));
            getNumber();
        }
        else if (str.contains("+") || str.contains("-") || str.contains("*") || str.contains("/")){
            for (int i = 0; i < str.length(); i++){
                String temp = String.valueOf(str.charAt(i));
                if (temp.matches("[+/*-]")){
                    String first = str.substring(0, i);
                    if (!first.equals("")){
                        map.put("num1", str.substring(0, i));
                        map.put("char", String.valueOf(str.charAt(i)));
                        map.put("num2", str.substring(i + 1));
                    } else {
                        map.put("char", String.valueOf(str.charAt(i)));
                        map.put("num2", str.substring(i + 1));
                    }
                    break;
                }
            }
        }
        else if (str.equals("exit")){
            flag = false;
            map.put("num1", "0");
            map.put("num2", "0");
        }
        else {
            getNumber();
        }
    }

    public static double calc() {
        String operation = map.get("char");
        try{
            switch (operation) {
                case "+" -> result = Double.parseDouble(map.get("num1")) + Double.parseDouble(map.get("num2"));
                case "-" -> result = Double.parseDouble(map.get("num1")) - Double.parseDouble(map.get("num2"));
                case "/" -> result = Double.parseDouble(map.get("num1")) / Double.parseDouble(map.get("num2"));
                case "*" -> result = Double.parseDouble(map.get("num1")) * Double.parseDouble(map.get("num2"));
                default -> {
                    result = calc();
                }
            }

        } catch (NumberFormatException e){
            System.out.println("Wrong input");
        }
        st.add(String.valueOf(result));
        map.put("num1", String.valueOf(result));
        return result;
    }
}
