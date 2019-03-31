package designpatterns.proxy;

public class ClassicalClub implements Club{
	@Override
	public void drink(String what) {
		System.out.println("drink -> " + what);
	}

	@Override
	public void feelTipsy() {
		System.out.println("feel tipsy.");
	}
}
