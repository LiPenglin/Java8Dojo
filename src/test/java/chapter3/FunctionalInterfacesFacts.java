package chapter3;

import chapter3.modle.Pear;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionalInterfacesFacts {

    @Test
    public void should_map_string_list_to_their_length() {
        ArrayList<String> strings = new ArrayList<String>() {
            {
                add("apple");
                add("orange");
                add("banana");
            }
        };

        Function<String, Integer> stringIntegerFunction = (String s) -> s.length();
        for (int i = 0; i < strings.size(); i++) {
            Assert.assertEquals(strings.get(i).length(),
                    FunctionalInterfacesInstance.map(
                            strings,
                            stringIntegerFunction
                    ));
        }

    }
    @Test
    public void should_create_apple_list_when_map() {
        List<Integer> weights = Arrays.asList(1, 3, 5, 7, 9);
        List<Pear> actual = FunctionalInterfacesInstance.map(
                weights,
                Pear::new
        );
        for (int i = 0; i < weights.size(); i++) {
            Assert.assertEquals(weights.get(i),
                    actual.get(i).getWeight());
        }
    }
}
