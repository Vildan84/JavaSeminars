package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        task3FromSeminar();
//        removeEvenNumbers();
//        MaxMinMid();

    }

    public static void task3FromSeminar() {
        Scanner scan = new Scanner(System.in);
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        int colNumber = 3;
        for (int i = 0; i < colNumber; i++){
            ArrayList<String> col = new ArrayList<>();
            System.out.printf("Заполните колонку № %d \n", i);
            boolean flag = true;
            while (flag){
                System.out.println("Введите название, для выхода введите 'q': ");
                String text = scan.nextLine();
                if (text.equals("q")){
                    flag = false;
                } else{
                    col.add(text);
                }
            }
            list.add(col);
        }
        scan.close();
        for (ArrayList<String> s : list) {
            System.out.println(s);
        }

    }

    public static void removeEvenNumbers () {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            int num = rand.nextInt(0, 200);
            list.add(num);
        }

        for (Integer number : list) {
            if (number % 2 == 1) {
                result.add(number);
            }
        }
        System.out.println(list.toString());
        System.out.println(result.toString());

    }

    public static void MaxMinMid () {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(0, 200);
            list.add(num);
        }
        System.out.println(list.toString());
        int max = list.get(0);
        int min = list.get(0);
        int sum = 0;

        for (Integer num : list) {
            if (num < min) {
                min = num;
                sum += num;
            } else if (num > max) {
                max = num;
                sum += num;
            } else {
                sum += num;
            }
        }
        int mid = sum / list.size();

        System.out.printf("Max number = %d; Min number = %d; Mid number = %d", max, min, mid);

    }
}
