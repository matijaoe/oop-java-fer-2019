package zad1;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {

    public static <T> Set<T> SetIntersection(Set<T> set1, Set<T> set2) {
        Set<T> newSet = new HashSet<T>();
        for (T element : set1){
            if (set2.contains(element)) {
                newSet.add(element);
            }
        }
        return newSet;
    }

    public static <T> Set<T> SetUnion(Set<T> set1, Set<T> set2) {
        Set<T> newSet = new HashSet<T>(set1);
        for (T element : set2){
            newSet.add(element);
        }
        return newSet;
    }

    public static <T> Set<T> SetDifference(Set<T> set1, Set<T> set2) {
        Set<T> newSet = new HashSet<T>();
        for (T element : set1){
            if (!set2.contains(element)) {
                newSet.add(element);
            }
        }
        return newSet;
    }
}