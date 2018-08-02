package chapter2;

import chapter2.modle.Apple;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BehaviorParameterizationFacts {
    @Test
    public void should_filtering_green_color_apple_by_first_attempt() {
        ArrayList<Apple> apples = new ArrayList<Apple>() {
            {
                add(new Apple("green"));
                add(new Apple("red"));
                add(new Apple("yellow"));
            }
        };
        ArrayList<Apple> expected = new ArrayList<Apple>() {
            {
                add(new Apple("green"));
            }
        };
        ArrayList<Apple> actual = new BehaviorParameterization()
                .filterGreenApples(apples);
        for (int i = 0; i < actual.size(); i++) {
            assertThat(expected.get(i), is(actual.get(i)));
        }
    }
}
