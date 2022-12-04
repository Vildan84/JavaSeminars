package org.example;

import java.util.LinkedList;


public class MyQueue{

    public void enqueue (LinkedList<Object> L, int Index){
        L.addLast(L.remove(Index));
    }

    public String dequeue (LinkedList<Object> L) {
        return (String) L.pollFirst();
    }

    public String first(LinkedList<Object> L){
        return (String) L.peekFirst();
    }

}


