package chapter5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UsingStreamsFacts {
    /*
        filter with a predicate.
     */
    @Test
    public void should_get_even_numbers() {
        int[] expectedNumbers = {0, 2, 4};
        int[] evenNumbers = IntStream.range(0, 5)
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
        int[] uniqueNumbers = IntStream.of(new int[]{1, 2, 2, 3, 3, 3})
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
        List<String> bottomString = Arrays.asList(new String[]{"a", "b", "c", "d"}).stream()
                .skip(3)
                .collect(Collectors.toList());
        Assert.assertEquals(expectedString, bottomString.get(0));
    }
}
