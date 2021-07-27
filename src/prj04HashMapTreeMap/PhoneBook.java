package prj04HashMapTreeMap;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/*
* 1. Напишите программу, которая будет работать как телефонная книга:
*
•	Если пишем новое имя, программа просит ввести номер телефона и запоминает его.
*   Если новый номер телефона — просит ввести имя и также запоминает.
•
* Если вводим существующее имя или номер телефона, программа выводит всю информацию о контакте.
*
•	При вводе команды LIST программа печатает в консоль список всех абонентов в алфавитном порядке с номерами.
*
2. Определяйте имя и телефон с помощью регулярных выражений.

* */

public class PhoneBook {
    private static final TreeMap<String, String> phoneBook = new TreeMap<>();

    private static final String regExpName = "([a-zA-Z]+)\\s?([a-zA-Z]+)\\s?([a-zA-Z]+)";
    private static final String regExpNumber = "(\\+{1})\\d{11}";

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String userInput = scanner.nextLine().trim();
            if (userInput.compareToIgnoreCase("list") == 0) { //if list command - show list
                printPhoneBook(phoneBook);
                continue;
            }
            if (userInput.compareToIgnoreCase("exit") == 0) {
                break;
            }
            if (isCorrectName(userInput)) { //if entered name
                if (phoneBook.containsKey(userInput)) { //if contains name - print contact
                    printContact(userInput);
                } else { //if not contains name
                    phoneBook.put(userInput, inputPhoneNumber());
                }
            } else if (isCorrectNumber(userInput)) { //if entered number
                if (phoneBook.containsValue(userInput)) {//if contains number - print contact
                    printAllContacts(userInput);
                } else { //if not contains number
                    phoneBook.put(inputName(), userInput);
                }
            } else {
                System.out.println("wrong command!!!");
            }
        }
    }

    private static String inputName() {
        String name = "";
        while (!isCorrectName(name)) {
            System.out.print("\tInput correct name: ");
            name = scanner.nextLine().trim();
        }
        return name;
    }

    private static String inputPhoneNumber() {
        String phoneNumber = "";
        while (!isCorrectNumber(phoneNumber)) {
            System.out.print("\tInput correct number: ");
            phoneNumber = scanner.nextLine().trim();
        }
        return phoneNumber;
    }


    private static void showMenu() {
        System.out.println("list - show phonebook");
        System.out.println("name - show info or add new contact");
        System.out.println("Phone - show info or add new contact");
        System.out.println("exit - close the program");
    }

    private static void printContact(String key) {
        System.out.println(key + " => " + phoneBook.get(key));
    }

    private static void printAllContacts(String number) { //print contacts with number phone
        for (String key : phoneBook.keySet()) {
            if (phoneBook.get(key).equals(number)) {
                printContact(key);
            }
        }
    }

    private static boolean isCorrectNumber(String number) {
        return number.matches(regExpNumber);
    }

    private static boolean isCorrectName(String name) {
        return name.matches(regExpName);
    }

    private static void printPhoneBook(Map<String, String> map) {
        Set<String> abonents = map.keySet();
        for (String abonent : abonents) {
            System.out.println(abonent + " => " + map.get(abonent));
        }
    }
}
