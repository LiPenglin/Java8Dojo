package designpatterns.prototype;

public class AdTemplate {
	private String subject;
	private String content;

	public AdTemplate(String subject, String content) {
		this.subject = subject;
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

}
