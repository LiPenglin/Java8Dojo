package java8.chapter2;

import java8.chapter2.BehaviorParameterization;
import java8.chapter2.modle.Apple;
import java8.chapter2.modle.ApplePredicate;
import java8.chapter2.modle.YellowAndHeavyApplePredicate;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BehaviorParameterizationFacts {
    private static ArrayList<Apple> apples;
    private static BehaviorParameterization behaviorParameterization;

    @BeforeClass
    public static void init() {
        apples = new ArrayList<Apple>() {
            {
                add(new Apple("green", 130));
                add(new Apple("red", 150));
                add(new Apple("yellow", 160));
            }
        };
        behaviorParameterization = new BehaviorParameterization();
    }
    @Test
    public void should_filtering_green_color_apple_by_first_attempt() {
        ArrayList<Apple> expected = new ArrayList<Apple>() {
            {
                add(new Apple("green", 150));
            }
        };
        ArrayList<Apple> actual = behaviorParameterization
                .filterGreenApples(apples);
        for (int i = 0; i < actual.size(); i++) {
            assertThat(expected.get(i).getColor(), is(actual.get(i).getColor()));
        }
    }
    @Test
    public void should_filtering_any_color_apple() {
        String expectColor = "red";
        ArrayList<Apple> actual = behaviorParameterization
                .filterAnyColorApples(apples, expectColor);
        for (int i = 0; i < actual.size(); i++) {
            assertThat(expectColor, is(actual.get(i).getColor()));
        }
    }

    @Test
    public void should_filtering_color_and_weight() {
        ArrayList<Apple> expect= new ArrayList<Apple>() {
            {
                add(new Apple("yellow", 160));
            }
        };
        YellowAndHeavyApplePredicate yellowAndHeavyApplePredicate = new YellowAndHeavyApplePredicate();
        ArrayList<Apple> actual = behaviorParameterization
                .filterColorAndWeight(apples, yellowAndHeavyApplePredicate);
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(expect.get(i), actual.get(i));
        }
    }

    @Test
    public void should_filtering_using_anonymous_class() {
        ArrayList<Apple> expect= new ArrayList<Apple>() {
            {
                add(new Apple("yellow", 160));
            }
        };
        ArrayList<Apple> actual = behaviorParameterization
                .filterColorAndWeight(apples, new ApplePredicate() {
                    @Override
                    public boolean selectApplesByCriteria(Apple apple) {
                        return "yellow".equals(apple.getColor())
                                && apple.getWeight() > 150;
                    }
                });
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(expect.get(i), actual.get(i));
        }
    }

    @Test
    public void should_filtering_using_lambda_expression() {
        ArrayList<Apple> expect= new ArrayList<Apple>() {
            {
                add(new Apple("yellow", 160));
            }
        };
        ArrayList<Apple> actual = behaviorParameterization
                .filterColorAndWeight(apples,
                        (Apple apple) -> "yellow".equals(apple.getColor()) && apple.getWeight() > 150);
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(expect.get(i), actual.get(i));
        }
    }

    @Test
    public void should_filtering_abstracting_over_list_type() {
        ArrayList<Apple> expect= new ArrayList<Apple>() {
            {
                add(new Apple("red", 150));
            }
        };
        // pass lambdas.
        List<Apple> actual = behaviorParameterization
                .filter(apples,
                        (Apple apple) -> "red".equals(apple.getColor()) && apple.getWeight() < 150);
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(expect.get(i), actual.get(i));
        }
    }
}
