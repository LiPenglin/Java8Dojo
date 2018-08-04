package chapter2;

import chapter2.modle.Apple;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BehaviorParameterizationFacts {
    private static ArrayList<Apple> apples;
    private static BehaviorParameterization behaviorParameterization;

    @BeforeClass
    public static void init() {
        apples = new ArrayList<Apple>() {
            {
                add(new Apple("green"));
                add(new Apple("red"));
                add(new Apple("yellow"));
            }
        };
        behaviorParameterization = new BehaviorParameterization();
    }
    @Test
    public void should_filtering_green_color_apple_by_first_attempt() {
        ArrayList<Apple> expected = new ArrayList<Apple>() {
            {
                add(new Apple("green"));
            }
        };
        ArrayList<Apple> actual = behaviorParameterization
                .filterGreenApples(apples);
        for (int i = 0; i < actual.size(); i++) {
            assertThat(expected.get(i), is(actual.get(i)));
        }
    }
    @Test
    public void should_filtering_any_color_apple() {
        String expectColor = "red";
        ArrayList<Apple> actual = behaviorParameterization
                .filterAnyColorApples(this.apples, expectColor);
        for (int i = 0; i < actual.size(); i++) {
            assertThat(expectColor, is(actual.get(i).getColor()));
        }
    }
}
