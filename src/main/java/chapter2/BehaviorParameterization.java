package chapter2;

import chapter2.modle.Apple;

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
}
