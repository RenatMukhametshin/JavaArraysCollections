package prj02Lists;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoListProgram {
    private static ArrayList<String> todoList = new ArrayList<>() {{
        add("learn oop java");
        add("cook the dinner");
        add("go to the training");
    }};
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String userInput = scanner.nextLine().trim();
            if (userInput.compareToIgnoreCase("exit") == 0) {
                break;
            }
            doCommand(userInput);
            System.out.println("\n");
        }
    }

    private static void doCommand(String userInput) {
        String commandName = getCommandName(userInput);
        if (commandName.compareToIgnoreCase("error_command") == 0) {
            System.out.println("Error the command. Please type the right command.");
            return;
        }
        if (commandName.compareToIgnoreCase("list") == 0) {
            showList();
        } else if (commandName.compareToIgnoreCase("add") == 0) {
            addList(userInput);
        } else if (commandName.compareToIgnoreCase("edit") == 0) {
            editList(userInput);
        } else if (commandName.compareToIgnoreCase("delete") == 0) {
            deleteList(userInput);
        }
    }

    private static void deleteList(String userInput) {
        int indexTaskForDelete = getIndexInCommand(userInput);
        if( indexTaskForDelete > todoList.size() || indexTaskForDelete <= 0 || todoList.size() == 0){
            System.out.println("Cannot delete task " + indexTaskForDelete);
        } else {
            System.out.println("Deleted task " + indexTaskForDelete + " - " + todoList.get(indexTaskForDelete - 1));
            todoList.remove(indexTaskForDelete - 1);
        }
    }

    private static void editList(String userInput) {
        System.out.println("do edit command...");
        int indexTaskForEdit = getIndexInCommand(userInput);
        System.out.println(indexTaskForEdit);

    }

    private static void addList(String userInput) {
        System.out.println("do add command...");
        int indexTaskForAdd = getIndexInCommand(userInput);
        System.out.println(indexTaskForAdd);
    }

    private static int getIndexInCommand(String userInput) {
        int firstSpaceIndex = userInput.indexOf(" ");
        int secondSpaceIndex = -1;
        String possibleIndex = "";
        if (firstSpaceIndex > 0) {
            secondSpaceIndex = userInput.indexOf(" ", firstSpaceIndex + 1);
        } else {
            return -1;
        }
        if (secondSpaceIndex > firstSpaceIndex) {
            possibleIndex = userInput.substring(firstSpaceIndex + 1, secondSpaceIndex);
        } else {
            possibleIndex = userInput.substring(firstSpaceIndex + 1);
        }
        if (possibleIndex.matches("\\d+")) {
            return Integer.parseInt(possibleIndex);
        } else {
            return -1;
        }
    }

    private static void showList() {
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + " - " + todoList.get(i));
        }
    }

    private static String getCommandName(String userInput) {
        String commandName = "ERROR_COMMAND";
        int indexSpace = userInput.indexOf(" ");
        if (indexSpace > 0) {
            commandName = userInput.substring(0, indexSpace);
        } else {
            commandName = userInput;
        }
        if (commandName.compareToIgnoreCase("add") != 0 && commandName.compareToIgnoreCase("edit") != 0 &&
                commandName.compareToIgnoreCase("list") != 0 && commandName.compareToIgnoreCase("delete") != 0) {
            commandName = "ERROR_COMMAND";
        }
        return commandName;
    }

    private static void showMenu() {
        int count = todoList.size();
        System.out.println("Todolist has " + count + " tasks.");
        System.out.println("Please type the command:");
        System.out.println("LIST - show list");
        System.out.println("ADD [index] - add new task at the end or at the index position");
        System.out.println("EDIT index EditedTask - replace the index task");
        System.out.println("DELETE index - delete the index task");
        System.out.println("EXIT - close the program");
        System.out.print("Input the command: ");
    }

}
