package prj03SetMap;

import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSet {
    private static final HashSet<String> emailSet = new HashSet<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean flag_stop_program = false;

    public static void main(String[] args) {
        while (!flag_stop_program) {
            showMenu();
            String userInput = scanner.nextLine().trim();
            doCommand(userInput);
        }
//        String[] emails = {"email@email.com", "email@email.", "emailemail.ru",
//                "@email.ru", "email2@email.ru", "email3@email.ru", "email2@email.ru", "email6@email.ru"};
    }

    private static void doCommand(String userInput) {
        String[] parseCommand = parseUserInput(userInput);
        if (parseCommand[0].compareToIgnoreCase("list") == 0 && parseCommand[1].length() == 0) {
            showEmailSet(emailSet);
        } else if (parseCommand[0].compareToIgnoreCase("add") == 0 && parseCommand[1].length() != 0) {
            addEmailSet(emailSet, parseCommand[1]);
        } else if (parseCommand[0].compareToIgnoreCase("exit") == 0 && parseCommand[1].length() == 0){
            flag_stop_program = true;
        } else {
            System.out.println("Wrong command format. Try again.");
        }
    }

    private static void addEmailSet(HashSet<String> emailSet, String email) {
        if(isCorrectEmail(email) && !existsEmailInSet(email)){
            emailSet.add(email);
            System.out.println("Added email - " + email);
            return;
        }
        if(!isCorrectEmail(email)){
            System.out.println("Email - " + email + " is not correct!!!");
        }
        if(existsEmailInSet(email)){
            System.out.println("Email - " + email + " is exists in the set!!!");
        }
    }

    private static String[] parseUserInput(String userInput) {
        String commandName = userInput;
        String textAfterCommand = "";
        if (userInput.length() == 0) {
            commandName = "ERROR_COMMAND";
        } else {
            int indexFirstSpace = commandName.indexOf(" ");
            if (indexFirstSpace > 0) {
                commandName = userInput.substring(0, indexFirstSpace);
                textAfterCommand = userInput.substring(indexFirstSpace + 1);
            } else {
                commandName = userInput;
            }
        }
        return new String[]{commandName, textAfterCommand};
    }

    private static void showMenu() {
        System.out.println("LIST - show the list of emails in the set");
        System.out.println("ADD email - add an email to the set");
        System.out.println("EXIT - exit the program");
        System.out.println("Type the command:");
    }

    private static boolean existsEmailInSet(String email) {
        if (emailSet == null) {
            return false;
        }
        return emailSet.contains(email);
    }

    private static boolean isCorrectEmail(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static void showEmailSet(HashSet<String> emailSet) {
        for (String email : emailSet) {
            System.out.println(email);
        }
    }
}
