package designpatterns.prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Mail implements Cloneable{

	private String receiver;
	private String subject;
	private String content;
	private ArrayList<String> carbonCopy2;

	public Mail(String receiver, AdTemplate template, String... cc) {
		this.receiver = receiver;
		subject = template.getSubject();
		content = template.getContent();
		carbonCopy2 = new ArrayList<>(Arrays.asList(cc));
		// clone 方法直接heap copy bit stream.
		System.out.println("constructor: " + toString());
	}

	@Override
	protected Mail clone() {
		Mail o = null;
		try {
			o = (Mail) super.clone();
		} catch (CloneNotSupportedException ignored) {}
		// 深拷贝
		Objects.requireNonNull(o).carbonCopy2 =
						(ArrayList<String>) this.carbonCopy2.clone();
		return o;
	}

	@Override
	public String toString() {
		return String.format("receiver: %s - subject: %s - content: %s - cc: %s.",
						receiver, subject, content, carbonCopy2);
	}

	public void clearCc() {
		carbonCopy2.clear();
	}
}
