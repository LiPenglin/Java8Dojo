package designpatterns.proxy;

import org.junit.Test;

public class Client {
	@Test
	public void should_print_pre_notice_when_invoke_real_subject() {
		ClassicalClub realClub = new ClassicalClub();
		Club proxy = ClubDynamicProxy.newProxyInstance(realClub);
		proxy.drink("whisky");
		proxy.feelTipsy();
	}
}
