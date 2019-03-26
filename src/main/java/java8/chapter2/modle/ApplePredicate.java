package java8.chapter2.modle;

/*
use a functional interface pass behavior.
 */
@FunctionalInterface
public interface ApplePredicate {
    boolean selectApplesByCriteria(Apple apple);
}
