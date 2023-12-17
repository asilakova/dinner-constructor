package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishlist = new HashMap<>();
    static Random random;

    void addDishList(String dishType, String dishName) {
        ArrayList<String> name = new ArrayList<>();
        if (dishlist.get(dishType) != null) {
            name = dishlist.get(dishType);
        }
        name.add(dishName);
        dishlist.put(dishType, name);
    }

    boolean checkType(String type) {
        if (dishlist.containsKey(type)) {
            return true;
        } else {
            return false;
        }
    }

    ArrayList<String> generationComboDishes(ArrayList<String> dishtypes) {
        Random random = new Random();
        ArrayList<String> dishCombo = new ArrayList<>();
            for (String type : dishlist.keySet()) { //забрать типы из выгруженного dishlist
                if (dishtypes.contains(type)) { //сравнить выгруженные типы с типами введенными пользователем
                    int randomIndex = random.nextInt(dishlist.get(type).size()); //обращаемся в dishlist по type пользователя и
                    // смотрим на размер значений, берем рандом в этих границах
                    dishCombo.add(dishlist.get(type).get(randomIndex)); //забираем рандомный элемент с индексом рандома
                }
            }
        return dishCombo;
    }
}






