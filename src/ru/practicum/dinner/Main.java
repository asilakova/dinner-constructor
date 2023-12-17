package ru.practicum.dinner;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;


    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;

            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addDishList(dishType,dishName);
        System.out.println("Добавлен тип блюда "+dishType + " с названием "+dishName);
        // добавьте новое блюдо
    }

   private static void generateDishCombo() {
        ArrayList <String> comboList = new ArrayList<>();
        comboList.add("");

        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        ArrayList<String> dishTypes = new ArrayList<>();
         // список введенных типов блюд

        while (!nextItem.isEmpty()) { //проверка типа на наличие, выполняется пока не введена пустая строка
            if (dc.checkType(nextItem)) { //обращаемся за проверкой наличия типа в хэшмапе
                dishTypes.add(nextItem); // тип есть - добавляем в массив dishTypes для дальнейшей работы
            } else {
                System.out.println("Типа блюда "+nextItem+" не существует, введите существующий тип");
            }
            nextItem = scanner.nextLine();
        }
        for (int i = 0; i < numberOfCombos; i++) {
            int x = i+1;
            System.out.println("Комбо "+ x);
            System.out.println(dc.generationComboDishes(dishTypes));
        }
    }
}
