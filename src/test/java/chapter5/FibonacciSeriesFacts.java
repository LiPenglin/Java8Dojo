package chapter5;

import org.junit.Test;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciSeriesFacts {
    @Test
    public void should_iterate_fibonacci_series() {
        Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    @Test
    public void should_generate_fibonacci_series() {
        IntStream.generate(new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int result = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return result;
            }
        })
                .limit(10)
                .forEach(System.out::println);
    }
}
