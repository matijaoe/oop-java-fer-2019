package hr.fer.oop.lab1;

import java.util.HashSet;
import java.util.Set;

public class Try {

    public static void main(String[] args) {

        Set<String> set1 = new HashSet<>();
        set1.add("Matija");
        set1.add("Teja");

        set1.forEach(s -> System.out.println(s));
    }
}
