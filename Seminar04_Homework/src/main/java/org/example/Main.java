package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import static org.example.MyQueue.*;

public class Main {
    public static void main(String[] args) {

//        task01();
        task02();
    }

    public static void task01(){
        String[] arr = {"cat", "dog", "mouse", "parrot", "fox"};
        LinkedList<String> list = new LinkedList<>(Arrays.asList(arr));
        LinkedList<String> result = new LinkedList<>();
        System.out.println(list);
        for (String str: list){
            result.addFirst(str);
        }
        System.out.println(result);
    }

    public static void task02(){
        String[] arr = {"cat", "dog", "mouse", "parrot", "fox"};
        LinkedList<Object> list = new LinkedList<>(Arrays.asList(arr));
        System.out.println(list);

        MyQueue queue = new MyQueue();
        queue.enqueue(list, 2);
        System.out.println(list);

        String res = queue.dequeue(list);
        System.out.println(res);
        System.out.println(list);

        String first = queue.first(list);
        System.out.println(first);
        System.out.println(list);
    }


}