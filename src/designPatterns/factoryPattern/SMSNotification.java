package designPatterns.factoryPattern;

public class SMSNotification implements Notification {

	@Override
	public void notifyUser() {
		System.out.println("SMSNotification sent to user");

	}

}
