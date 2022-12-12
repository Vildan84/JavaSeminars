package org.example;

import java.util.HashSet;
import java.util.Scanner;


public class Main {

    static HashSet<NoteBook> set = new HashSet<>();
    static boolean flag = true;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        createNote();
        while (flag){
            menu();
        }
    }

    public static void menu(){

        System.out.println();
        System.out.println("--------------------/////-------------------");
        System.out.println("Добро пожаловать в каталог ноутбуков, выберете пункт меню:");
        System.out.println("1. Посмотреть весь каталог");
        System.out.println("2. Фильтр");
        System.out.println("3. Выход");
        System.out.println("Ввод: ");
        String number = scan.nextLine();
        switch (number) {
            case "1" -> {
                for (NoteBook nb : set) {
                    nb.info();
                }
            }
            case "2" -> getParameters();
            case "3" -> flag = false;
            default -> {
                System.out.println("Неверный ввод");
                menu();
            }
        }

    }

    public static void getParameters(){
        System.out.println();
        System.out.println("--------------------/////-------------------");
        System.out.println("Введите параметр фильтрации:\n1. Брэнд\n2. Тип ОС\n3. Объем RAM\n4. Объем SSD\n5. Выход в главное меню\n");
        System.out.println("Ввод: ");
        String num = scan.nextLine();
        switch (num) {
            case "1" -> {
                System.out.println("Введите название: ");
                String brand = scan.nextLine().toLowerCase();
                filter.filterByBrand(set, brand);
                getParameters();
            }
            case "2" -> {
                System.out.println("Введите название: windows, linux, noos");
                String os = scan.nextLine().toLowerCase();
                filter.filterByOS(set, os);
                getParameters();
            }
            case "3" -> {
                System.out.println("Введите минимально желаемое количество RAM в Gb: ");
                String input = scan.nextLine();
                if (input.matches("-?\\d+(\\.\\d+)?")) {
                    int ram = Integer.parseInt(input);
                    filter.filterByRam(set, ram);
                    getParameters();
                } else {
                    System.out.println("Неверный ввод");
                    getParameters();
                }
            }
            case "4" -> {
                System.out.println("Введите минимально желаемый объем SSD в Gb: ");
                String input = scan.nextLine();
                if (input.matches("-?\\d+(\\.\\d+)?")) {
                    int rom = Integer.parseInt(input);
                    filter.filterByRom(set, rom);
                    getParameters();
                } else {
                    System.out.println("Неверный ввод");
                    getParameters();
                }
            }
            case "5" -> menu();
            default -> System.out.println("Неверный ввод");
        }
    }

    public static void createNote(){
        creator cr = new creator();

        NoteBook note1 = new NoteBook();
        cr.makeNote(note1);
        set.add(note1);
        NoteBook note2 = new NoteBook();
        cr.makeNote(note2);
        set.add(note2);
        NoteBook note3 = new NoteBook();
        cr.makeNote(note3);
        set.add(note3);
        NoteBook note4 = new NoteBook();
        cr.makeNote(note4);
        set.add(note4);
        NoteBook note5 = new NoteBook();
        cr.makeNote(note5);
        set.add(note5);
        NoteBook note6 = new NoteBook();
        cr.makeNote(note6);
        set.add(note6);
        NoteBook note7 = new NoteBook();
        cr.makeNote(note7);
        set.add(note7);
        NoteBook note8 = new NoteBook();
        cr.makeNote(note8);
        set.add(note8);
        NoteBook note9 = new NoteBook();
        cr.makeNote(note9);
        set.add(note9);
        NoteBook note10 = new NoteBook();
        cr.makeNote(note10);
        set.add(note10);
        NoteBook note11 = new NoteBook();
        cr.makeNote(note11);
        set.add(note11);
    }

}