package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionalInterfacesInstance {

    public static <T, R> List<R> map(List<T> list,
                                     Function<T, R> f) {
        ArrayList<R> result = new ArrayList<>();
        for (T t: list) {
            /*
            Function<T, R> interface defines an abstract method named apply
            that take T and return R.
             */
            /*
            Predicate<T> interface defines an abstract method named test
            that take T and return boolean.
             */
            /*
            Consumer<T> interface defines an abstract method named accept
            that take T but return void.
             */
            /*
            other:
            Supplier<T> Creating objects.
            IntBinaryOperator Combine values.
            Comparator<T> Compare two objects.
            Google Search: java 8 functional interfaces
             */
            result.add(f.apply(t));
        }
        return result;
    }
}
