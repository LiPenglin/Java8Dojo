package designpatterns.proxypattern;

public class PreNotice implements INotice{
	@Override
	public void exec() {
		System.out.println("welcome to club.");
	}
}
