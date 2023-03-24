package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Sem6 {
    public static void main(String[] args) {
        MySet ms = new MySet();
        ms.add(1);
        ms.add(2);
        ms.add(3);
        ms.add(4);
        ms.add(5);
        ms.add(6);
        ms.add(7);
        ms.print();
        System.out.println(ms.toListUpToElement(5));
    }
}

class MySet {
    private HashMap<Integer, Object> myset;
    private static final Object OOO = new Object();

    public MySet() {
        this.myset = new HashMap<>();
    }

    public void add(Integer number) {
        this.myset.putIfAbsent(number, OOO);
    }

    public void delete(Integer number) {
        this.myset.remove(number);
    }

    public void print() {
        myset.forEach((k, v) -> System.out.print(k + " "));
        System.out.println();
    }

    public void unite(MySet otherSet) {
        otherSet.myset.forEach((k, v) -> this.add(k));
    }

    public int size() {
        return this.myset.size();
    }

    public int get(int index) {
        return (int) this.myset.keySet().toArray()[index];
    }
    public ArrayList<Integer> toList() {
        return new ArrayList<Integer>(this.myset.keySet());
    }

    public ArrayList<Integer> toListUpToElement(int element) {
        if (!myset.containsKey(element)) return null;
        ArrayList<Integer> output = new ArrayList<>();
        for (int k:
                myset.keySet()) {
            output.add(k);
            if (k ==element) break;
        }
        return output;
    }
}