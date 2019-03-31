package designpatterns.prototype;

import org.junit.Test;

public class Client {
	@Test
	public void should_return_another_obj_by_clone_method() {
		Mail mailA = new Mail("lee",
						new AdTemplate("Say Hi.", "hi, how are U."),
						"a", "b", "c");
		Mail mailB = mailA.clone();

		// 改变mailA 的cc
		mailA.clearCc();
		System.out.println("A: " + mailA + "\nB: " + mailB);
	}
}
