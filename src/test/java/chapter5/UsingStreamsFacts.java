package chapter5;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UsingStreamsFacts {
    // filtering and slicing.
    /*
        filter with a predicate.
     */
    @Test
    public void should_get_even_numbers() {
        int[] expectedNumbers = {0, 2, 4};
        int[] evenNumbers = IntStream.rangeClosed(0, 5)
                .filter(i -> i % 2 == 0)
                .toArray();
        Assert.assertArrayEquals(expectedNumbers, evenNumbers);
    }

    /*
        filter unique elements.
     */
    @Test
    public void should_get_unique_numbers() {
        int[] expectedNumbers = {1, 2, 3};
        int[] uniqueNumbers = IntStream.of(1, 2, 2, 3, 3, 3)
                .distinct()
                .toArray();
        Assert.assertArrayEquals(expectedNumbers, uniqueNumbers);
    }

    /*
        truncate a stream.
     */
    @Test
    public void should_get_top_three_strings() {
        String[] expectedStrings = {"a", "b", "c"};
        List<String> top3Strings = Stream.of(new String[]{"a", "b", "c", "d"})
                .limit(3)
                .collect(Collectors.toList());
        Assert.assertArrayEquals(expectedStrings, top3Strings.toArray());
    }

    /*
        skip elements.
     */
    @Test
    public void should_get_bottom_string() {
        String expectedString = "d";
        List<String> bottomString = Arrays.stream(new String[]{"a", "b", "c", "d"})
                .skip(3)
                .collect(Collectors.toList());
        Assert.assertEquals(expectedString, bottomString.get(0));
    }

    // mapping
    /*
        apply a function to each elements of a stream.
     */
    @Test
    public void each_element_should_multiply_two() {
        int[] expectedNumbers = {2, 4, 6};
        int[] doubleValueNumbers = IntStream.rangeClosed(1, 3)
                .map(i -> i << 1)
                .toArray();
        Assert.assertArrayEquals(expectedNumbers, doubleValueNumbers);
    }

    /*
        flattening streams.
     */
    @Test
    public void given_two_lists_should_generate_pairs() {
        List<String[]> expectedPairs = new ArrayList<String[]>() {
            {
                add(new String[]{"a", "A"});
                add(new String[]{"a", "B"});
                add(new String[]{"b", "A"});
                add(new String[]{"b", "B"});
            }
        };
        List<String> list1 = Arrays.asList("a", "b");
        List<String> list2 = Arrays.asList("A", "B");
        /*
            flatMap:
            1. replace each value of a stream with another stream.
            2. concatenate all the generated streams into a single stream.
         */
        List<String[]> actualPairs = list1.stream()
                .flatMap(s1 -> list2.stream()
                        .map(s2 -> new String[]{s1, s2})
                )
                .collect(Collectors.toList());
        Assert.assertArrayEquals(expectedPairs.toArray(), actualPairs.toArray());

    }
}
