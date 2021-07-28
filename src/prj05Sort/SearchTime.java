package prj05Sort;

import java.util.*;

public class SearchTime {
    private static final ArrayList<String> numberList = new ArrayList<>();
    private static final HashSet<String> numberHashSet = new HashSet<>();
    private static final TreeSet<String> numberTreeSet = new TreeSet<>();

    public static void main(String[] args) {
        long startNano = System.nanoTime();
        long startMilli = System.currentTimeMillis();
        numbersGenerator();
        numberHashSet.addAll(numberList);
        numberTreeSet.addAll(numberList);
        long endNano = System.nanoTime();
        long endMilli = System.currentTimeMillis();
        System.out.println("Collections created in:");
        System.out.println("nano time : " + (endNano - startNano) * 1.0 / 1000000000);
        System.out.println("milli time : " + (endMilli - startMilli) * 1.0 / 1000);

        System.out.println("\n\n\n");
        Scanner scanner = new Scanner(System.in);

//        for(int i = 0; i < 10; i++){
//            System.out.println(numberList.get(i));
//        }

        while(true){
            System.out.print("Input the number [xYYYbbCCC] : ");
            String number = scanner.nextLine().trim();
            if(number.compareToIgnoreCase("exit") == 0){
                break;
            }
            listSearch(number);
            listBinarSearch(number);
            listHashSetSearch(number);
            listTreeSetSearch(number);
        }
    }

    private static void listTreeSetSearch(String number) {
        long start = System.nanoTime();
        boolean result = numberTreeSet.contains(number);
        long end = System.nanoTime();
        double searchTime = (end - start) * 1.0 / 1000000000;
        System.out.println("TreeSet Search : " + ((result)?" number found ":" number is not found ") + ", search time " + searchTime + " nanoSecs");
    }

    private static void listHashSetSearch(String number) {
        long start = System.nanoTime();
        boolean result = numberHashSet.contains(number);
        long end = System.nanoTime();
        double searchTime = (end - start) * 1.0 / 1000000000;
        System.out.println("HashSet Search : " + ((result)?" number found ":" number is not found ") + ", search time " + searchTime + " nanoSecs");
    }

    private static void listBinarSearch(String number) {
        long start = System.nanoTime();
        int result = Collections.binarySearch(numberList, number);
        long end = System.nanoTime();
        double searchTime = (end - start) * 1.0 / 1000000000;
        System.out.println("Binar Search : " + ((result >= 0)?" number found ":" number is not found ") + ", search time " + searchTime + " nanoSecs");

    }

    private static void listSearch(String number){
        long start = System.nanoTime();
        boolean isExists = numberList.contains(number);
        long end = System.nanoTime();
        double searchTime = (end - start) * 1.0 / 1000000000;
        System.out.println("List Search : " + ((isExists)?" number found ":" number is not found ") + ", search time " + searchTime + " nanoSecs");
    }

    private static void numbersGenerator() {
        /*XYZ — letters, N — numbers , R — regin (от 001 до 199);
        XNNNYZR — пример, A111BB197, Y777HC66,
        * */
        int count = 0;
        StringBuilder regionStr = new StringBuilder();
        for (int i = 111; i <= 999; i += 111) {
            for (char letter1 = 'A'; letter1 <= 'Z'; letter1++) {
                for (char letter2 = 'A'; letter2 <= 'Z'; letter2++) {
                    // for (char letter3 = 'A'; letter3 <= 'Z'; letter3++) {
                    for (int region = 1; region <= 199; region++) {
                        regionStr.append("00" + region);
                        numberList.add((" " + letter1 + i + letter2 + letter2 +
                                regionStr.substring(regionStr.length() - 3)).trim());
                        count++;
                        regionStr.setLength(0);
                        // }
                    }
                }
            }
        }
        Collections.sort(numberList);
        System.out.println(count + " numbers generated");
    }
}
