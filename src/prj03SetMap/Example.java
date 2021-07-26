package prj03SetMap;

import java.util.HashSet;
import java.util.TreeSet;

public class Example {
    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>();
        words.add("First");
        words.add("Second");
        words.add("Third");
        words.add("Second");

        for(String word : words){
            System.out.println(word);
        }
        System.out.println(words.contains("Second"));
        System.out.println(words.contains("Zero"));


        TreeSet<String> teams = new TreeSet<>();
        teams.add("Ferrari");
        teams.add("Aston Martin");
        teams.add("Alfa Tauri");
        teams.add("Haas");

        for(String team : teams){
            System.out.println(team);
        }
        System.out.println(teams.contains("Ferrari"));
        System.out.println(teams.contains("Mercedes"));
    }
}
