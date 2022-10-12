package designPatterns.factoryPattern;

public class PushNotification implements Notification {

	@Override
	public void notifyUser() {
		System.out.println("PushNotification sent to user");

	}

}
