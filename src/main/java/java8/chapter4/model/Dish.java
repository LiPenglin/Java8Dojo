package java8.chapter4.model;

public class Dish {
    private Integer calories;
    private String name;

    public Dish(Integer calories, String name) {
        this.calories = calories;
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
