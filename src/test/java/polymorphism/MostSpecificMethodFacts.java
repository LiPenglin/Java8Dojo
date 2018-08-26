package polymorphism;

import org.junit.Assert;
import org.junit.Test;

public class MostSpecificMethodFacts {

    @Test
    public void should_say_IAmCat_when_actual_type_is_cat() {
        Animal cat = new Cat();

        /*
        1. run time.
        2. according to actual type.
         */
        String expected = "I am cat.";
        Assert.assertEquals(expected, cat.selfIntroduction());
    }
    @Test
    public void should_say_IAmAnimal_when_actual_type_is_dog_but_not_overwrite_introduce_method() {
        Animal dog = new Dog();

        /*
        1. method area -> virtual method table
        2. if child class virtual method table do not have method, than call method in parent table.
         */
        
        String expected = "I am animal.";
        Assert.assertEquals(expected, dog.selfIntroduction());
    }

}
