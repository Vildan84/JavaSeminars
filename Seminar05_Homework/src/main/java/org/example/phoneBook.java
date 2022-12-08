package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class phoneBook {
    static HashMap<String, ArrayList<String>> map = new HashMap<>();
    static Scanner scan = new Scanner(System.in);
    static boolean flag = true;
    public static void main(String[] args){

        while(flag){
            menu();
        }

    }
    public static void menu(){
        System.out.println("Добавить контакт: 1\nДобавить номер: 2\nНайти контакт: 3\nВсе контакты: 4\nВыход: q");
        String str = scan.nextLine();
        if (str.equals("1")){
            addName();
        }
        else if (str.equals("2")){
            addPhoneNumber();
        }
        else if (str.equals("3")){
            findContact();
        }
        else if (str.equals("4")){
            System.out.println("/////////////////////////////////////////////////");
            System.out.println(map);
            System.out.println("////////////////////////////////////////////////");

        }
        else if (str.equals("q")){
            flag = false;
        }
        else {
            System.out.println("//////////////");
            System.out.println("Неверный ввод");
            System.out.println("//////////////");
        }
    }

    public static void addName(){
        ArrayList<String> temp = new ArrayList<>();
        System.out.println("Введите ФИО ");
        String name = scan.nextLine();
        if (map.containsKey(name)){
            System.out.println("//////////////////////");
            System.out.println("Такой контакт уже есть");
            System.out.println("//////////////////////");
        }
        else {
            System.out.println("Введите номер телефона ");
            String number = scan.nextLine();
            temp.add(number);
            map.putIfAbsent(name, temp);
        }
    }

    public static void findContact(){
        System.out.println("Введите ФИО ");
        String name = scan.nextLine();
        if (map.containsKey(name)){
            System.out.println("//////////////////");
            System.out.println(map.get(name));
            System.out.println("//////////////////");
        }
        else{
            System.out.println("//////////////////");
            System.out.println("Контакт не найден");
            System.out.println("//////////////////");
        }
    }

    public static void addPhoneNumber(){
        System.out.println("Введите контакт");
        String name = scan.nextLine();
        if (map.containsKey(name)){
            System.out.println("Введите номер телефона");
            String number = scan.nextLine();
            ArrayList<String> temp = new ArrayList<>(map.get(name));
            temp.add(number);
            map.put(name, temp);
        }
        else {
            System.out.println("//////////////////");
            System.out.println("Контакт отсутствует");
            System.out.println("//////////////////");
        }
    }
}
