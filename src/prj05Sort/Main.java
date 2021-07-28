package prj05Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();

        Collections.sort(items);
        Collections.binarySearch(items,"value");

        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(items);

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.addAll(items);


    }
}
