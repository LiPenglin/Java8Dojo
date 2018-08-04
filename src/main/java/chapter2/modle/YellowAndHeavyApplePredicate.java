package chapter2.modle;

public class YellowAndHeavyApplePredicate implements ApplePredicate{
    @Override
    public boolean selectApplesByCriteria(Apple apple) {
        return "yellow".equals(apple.getColor())
                && apple.getWeight() > 150;
    }
}
