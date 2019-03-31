package designpatterns.proxy;

public class ClubDynamicProxy extends DynamicProxy<Club> {
	public static <T> T newProxyInstance(Club club) {
		ClassLoader classLoader = club.getClass().getClassLoader();
		Class<?>[] interfaces = club.getClass().getInterfaces();
		ClubHandler clubHandler = new ClubHandler(club);
		return newProxyInstance(classLoader, interfaces, clubHandler);
	}
}
