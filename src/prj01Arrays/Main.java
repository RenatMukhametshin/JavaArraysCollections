package prj01Arrays;

public class Main {
    public static void main(String[] args) {
        int[] roomCounts = new int[6];
        roomCounts[0] = 5;
        roomCounts[1] = 24;
        roomCounts[2] = 45;
        roomCounts[3] = 38;
        roomCounts[4] = 44;
        roomCounts[5] = 29;
        for (int i = 0; i < roomCounts.length; i++) {
            System.out.println(roomCounts[i]);
        }

        int[] houseCounts = {1, 2, 3, 4};
        for (int i = 0; i < houseCounts.length; i++) {
            System.out.println(houseCounts[i]);
        }

        //*******************************
        String text = "Every hunter wish to know, where is now a fazan";
        String[] words = text.split(",?\\s+");
        for (String word : words){
            System.out.println(word);
        }
    }

}
