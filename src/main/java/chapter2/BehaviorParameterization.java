package chapter2;

import chapter2.modle.Apple;
import chapter2.modle.ApplePredicate;
import chapter2.modle.Predicate;

import java.util.ArrayList;
import java.util.List;

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

    // execute a behavior in task function.
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t: list) {
            if (p.selectByCriteria(t)) {
                result.add(t);
            }
        }
        return result;
    }


}
