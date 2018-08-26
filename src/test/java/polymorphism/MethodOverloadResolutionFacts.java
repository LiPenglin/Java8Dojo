package polymorphism;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MethodOverloadResolutionFacts {

    private static StaticDispatch dispatcher;

    @BeforeClass
    public static void init() {
        dispatcher = new StaticDispatch();
    }

    @Test
    public void should_say_ThisIsAnimal_when_static_type_is_animal() {
        Animal cat = new Cat();
        Animal dog = new Dog();

        /*
        1. compile time
        2. according to static type.
        2. which is more appropriate .
         */
        String expected = "This is animal.";
        Assert.assertEquals(expected, dispatcher.what(cat));
        Assert.assertEquals(expected, dispatcher.what(dog));
    }

    @Test
    public void should_true_when_runtime_type_in_inheritance_chain() {
        Animal cat = new Cat();
        Garfield garfield = new Garfield();

        Assert.assertTrue(cat instanceof Animal);
        Assert.assertTrue(garfield instanceof Cat);
        Assert.assertTrue(garfield instanceof Animal);
    }
}
