package chapter2;

import chapter2.modle.Apple;
import chapter2.modle.ApplePredicate;

import java.util.ArrayList;

public class BehaviorParameterization {
    public ArrayList<Apple> filterGreenApples(ArrayList<Apple> apples) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple: apples) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public ArrayList<Apple> filterAnyColorApples(ArrayList<Apple> apples, String color) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple: apples) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public ArrayList<Apple> filterColorAndWeight(ArrayList<Apple> apples, ApplePredicate predicate) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple: apples) {
            if (predicate.selectApplesByCriteria(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
