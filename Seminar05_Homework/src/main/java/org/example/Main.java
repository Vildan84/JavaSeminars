package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Task02();

    }

    public static void Task02(){

        String[] list = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};
        HashMap<String, Integer> map = new LinkedHashMap<>();


        for (String str: list){
            String name = str.split(" ")[0];

            if (map.containsKey(name)){
                int temp = map.get(name);
                temp++;
                map.put(name, temp);
            }
            else {
                map.put(name, 1);
            }
        }
        System.out.println(map);

        LinkedHashMap<String, Integer> sortedMap = map.entrySet().stream().
                sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMap);


    }

}