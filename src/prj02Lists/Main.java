package prj02Lists;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> todoList = new ArrayList<>();

        todoList.add("first task");
        todoList.add("second task");
        todoList.add(0, "third task");

        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(todoList.get(i));
        }

        ArrayList<String> carList = new ArrayList<>(){{
            add("Red Bull");
            add("Ferrari");
            add("McLaren");
            add("Mercedes");
        }};

        carList.add("Alfa Romeo");
        carList.remove(2);
        carList.add(1,"Aston Martin");

        for(String car : carList){
            System.out.println(car);
        }
    }
}
