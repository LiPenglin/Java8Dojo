package chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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
}
