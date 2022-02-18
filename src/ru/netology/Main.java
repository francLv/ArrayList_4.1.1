package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<String> todo = new ArrayList<>();

    public static void main(String[] args) {
        int stop = 1;
        while (stop != 0) {
            menu();
            switch (input()) {
                case 1:
                    System.out.println("Введите задачу для планирования:");
                    todo.add(scanner.nextLine());
                    break;
                case 2:
                    printList();
                    break;
                case 3:
                    if (!todo.isEmpty()) {
                        System.out.println("Введите номер задачи для удаления:");
                        try {
                            todo.remove(input() - 1);
                            printList();
                        } catch (IndexOutOfBoundsException err) {
                            System.out.println("Нет такой задачи, повторите");
                        }
                    } else System.out.println("Список задач пуст");
                    break;
                case 4:
                    continue;
                case 0:
                    stop = 0;
            }
        }
    }


    static void menu() {
        System.out.println("Выберите действие:\n" +
                "1. Добавить задачу\n" +
                "2. Вывести спиок задач\n" +
                "3. Удалить задачу\n" +
                "0. Выход");
    }

    static int input() {
        int err = 4;
        try {
            int input = Integer.parseInt(scanner.nextLine());
            if (input >= 0 && input < err) {
                return input;
            } else {
                return err;
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число, повторите");
        }
        return err;
    }

    static void printList() {
        int itemNum = 1;
        if (!todo.isEmpty()) {
            for (int i = 0; i < todo.size(); i++) {
                System.out.println(itemNum + "." + todo.get(i));
                itemNum++;
            }
        } else System.out.println("Список задач пуст");
    }

//    static void printList(){
//        int itemNum = 1;
//        if (!todo.isEmpty()) {
//            for (Iterator<String> iter = todo.iterator(); iter.hasNext(); ) {
//                System.out.println(itemNum + "." + iter.next());
//                itemNum++;
//            }
//        } else System.out.println("Список задач пуст");
//    }

//    static void printList() {
//        int itemNum = 1;
//        Iterator<String> iterator = todo.iterator();
//        while (iterator.hasNext()){
//            System.out.println(itemNum + "." + iterator.next());
//            itemNum++;
//        }
//    }

//    static void printList() {
//        int i = 1;
//        if (!todo.isEmpty()){
//            for (String s : todo) {
//                System.out.println(i + "." + s);
//                i++;
//            }
//            System.out.println();
//        } else System.out.println("Список задач пуст");
//    }

}
