package designPatterns.factoryPattern;

public class EmailNotification implements Notification {

	@Override
	public void notifyUser() {
		System.out.println("EmailNotification sent to user");

	}

}
