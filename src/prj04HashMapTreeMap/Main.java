package prj04HashMapTreeMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        //HashMap<String, Integer> good2count = new HashMap<>(); //keys not sorted
        TreeMap<String, Integer> good2count = new TreeMap<>(); // keys sorted
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            String goodName = scanner.nextLine();
            if (goodName.compareToIgnoreCase("list") == 0) {
                printMap(good2count);
                continue;
            }
            if (goodName.compareToIgnoreCase("exit") == 0) {
                break;
            }
            int count = 1;
            if (good2count.containsKey(goodName)) {
                count = good2count.get(goodName) + 1;
            }
            good2count.put(goodName, count);
        }
    }

    private static void printMap(Map<String, Integer> map) {
        for (String key : map.keySet()) {
            System.out.println(key + " => " + map.get(key));
        }
    }
}
