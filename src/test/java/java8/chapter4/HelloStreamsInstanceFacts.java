package java8.chapter4;

import java8.chapter4.HelloStreamsInstance;
import java8.chapter4.model.Dish;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HelloStreamsInstanceFacts {

    private static ArrayList<Dish> expectDishes;
    private static ArrayList<Dish> dishes;

    @BeforeClass
    public static void init() {
        dishes = new ArrayList<Dish>() {
            {
                add(new Dish(200, "Alpha"));
                add(new Dish(400, "Beta"));
                add(new Dish(600, "Gamma"));
                add(new Dish(800, "Delta"));
                add(new Dish(1000, "Epsilon"));
            }
        };
        expectDishes = new ArrayList<Dish>() {
            {
                add(new Dish(200, "Alpha"));
            }
        };
    }

    @Test
    public void should_return_sorted_by_low_calories_names_of_dishes_when_use_streams() {
        List<String> actualDishes = HelloStreamsInstance.getLowCaloriesDishesNames(dishes);
        for (int i = 0; i < expectDishes.size(); i++) {
            Assert.assertEquals(expectDishes.get(i).getName(), actualDishes.get(i));
        }
    }

    @Test
    public void should_return_sorted_by_low_calories_names_of_dishes_when_use_parallel_streams() {
        List<String> actualDishes = HelloStreamsInstance.getLowCaloriesDishesNamesByParallelStream(dishes);
        for (int i = 0; i < expectDishes.size(); i++) {
            Assert.assertEquals(expectDishes.get(i).getName(), actualDishes.get(i));
        }
    }
}
