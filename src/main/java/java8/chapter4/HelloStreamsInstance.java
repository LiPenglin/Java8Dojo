package java8.chapter4;

import java8.chapter4.model.Dish;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class HelloStreamsInstance {

    public static List<String> getLowCaloriesDishesNames(ArrayList<Dish> dishes) {
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }

    public static List<String> getLowCaloriesDishesNamesByParallelStream(ArrayList<Dish> dishes) {
        return dishes.parallelStream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());

    }
}
