package designPatterns.factoryPattern;

public class NotificationService {

	public static void main(String[] args) {
		NotificationFactory notificationFactory = new NotificationFactory();
		Notification notification = notificationFactory.createNotificationService("EMAIL");
		notification.notifyUser();
	}
}
