package prj01Arrays;

public class ReverseStringArray {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] words = text.split(",?\\s+");
        System.out.println("Income array:");
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println("\nReverse array:");
        String[] reverseWords = reverseArray(words);
        for (String word : reverseWords){
            System.out.print(word + " ");
        }

    }

    public static String[] reverseArray(String[] array) {
        int arraySize = array.length;
        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[arraySize - 1 - i];
            array[arraySize - 1 - i] = temp;
        }
        return array;
    }
}
