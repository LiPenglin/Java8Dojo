package polymorphism;

public class StaticDispatch {
    public String what(Animal animal) {
        return "This is animal.";
    }

    public String what(Cat cat) {
        return "This is cat.";
    }

    public String what(Dog dog) {
        return "This is dog.";
    }
}
