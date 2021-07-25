package prj02Lists;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoListProgram {
    private static final ArrayList<String> todoList = new ArrayList<>() {{
        add("learn oop java");
        add("cook the dinner");
        add("go to the training");
    }};
    private static final Scanner scanner = new Scanner(System.in);

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
        int indexTaskForDelete = getTaskNumberInCommand(userInput);
        if (indexTaskForDelete > todoList.size() || indexTaskForDelete <= 0 || todoList.size() == 0) {
            System.out.println("Cannot delete task " + indexTaskForDelete);
        } else {
            System.out.println("Deleted task " + indexTaskForDelete + " - " + todoList.get(indexTaskForDelete - 1));
            todoList.remove(indexTaskForDelete - 1);
        }
    }

    private static void editList(String userInput) {
        int indexTaskForEdit = getTaskNumberInCommand(userInput);
        if (indexTaskForEdit > todoList.size() || indexTaskForEdit <= 0 || todoList.size() == 0) {
            System.out.println("Cannot edit task " + indexTaskForEdit);
        } else {
            String textTask = getTaskTextInCommand(userInput);
            System.out.println("Edited task " + indexTaskForEdit + " - " + todoList.get(indexTaskForEdit - 1));
            todoList.set(indexTaskForEdit - 1, textTask);
        }
    }

    private static void addList(String userInput) {
        int indexTaskForAdd = getTaskNumberInCommand(userInput);
        String textTask = getTaskTextInCommand(userInput);
        if (textTask.length() != 0) {
            if (indexTaskForAdd > todoList.size() || todoList.size() == 0 || indexTaskForAdd == -1) {
                todoList.add(textTask);
            } else {
                todoList.add(indexTaskForAdd - 1, textTask);
            }
            System.out.println("added task");
        } else {
            System.out.println("cannot added task");
        }
    }


    private static String getTaskTextInCommand(String userInput) {
        String taskText = "";
        int indexFirstSpace = userInput.indexOf(" ");
        int indexSecondSpace;
        if (indexFirstSpace > 0) {
            indexSecondSpace = userInput.indexOf(" ", indexFirstSpace + 1);
            if (indexSecondSpace > indexFirstSpace) {
                taskText = userInput.substring(indexSecondSpace + 1);
            } else {
                taskText = userInput.substring(indexFirstSpace + 1);
            }
            if(getCommandName(userInput).compareToIgnoreCase("add") == 0 && getTaskNumberInCommand(userInput) == -1)
                taskText = userInput.substring(indexFirstSpace + 1);
        }
        return taskText;
    }

    private static int getTaskNumberInCommand(String userInput) {
        int firstSpaceIndex = userInput.indexOf(" ");
        int secondSpaceIndex;
        String possibleIndex;
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
        String commandName;
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
