package bridge;

interface CommunicationChannel {
    void sendMessage(String message);
}

class EmailChannel implements CommunicationChannel {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SMSChannel implements CommunicationChannel {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

abstract class Notification {
    protected CommunicationChannel channel;

    public Notification(CommunicationChannel channel) {
        this.channel = channel;
    }

    public abstract void notifyUser(String messageContent);
}

class AlertNotification extends Notification {

    public AlertNotification(CommunicationChannel channel) {
        super(channel);
    }

    @Override
    public void notifyUser(String messageContent) {
        String alertMessage = "ALERT: " + messageContent;
        channel.sendMessage(alertMessage);
    }
}

class PromotionNotification extends Notification {

    public PromotionNotification(CommunicationChannel channel) {
        super(channel);
    }

    @Override
    public void notifyUser(String messageContent) {
        String promoMessage = "PROMOTION: " + messageContent;
        channel.sendMessage(promoMessage);
    }
}

public class BridgeExample {
    public static void main(String[] args) {
        CommunicationChannel emailChannel = new EmailChannel();
        Notification alertEmailNotification = new AlertNotification(emailChannel);
        alertEmailNotification.notifyUser("This is a security alert!");

        System.out.println();

        CommunicationChannel smsChannel = new SMSChannel();
        Notification promoSMSNotification = new PromotionNotification(smsChannel);
        promoSMSNotification.notifyUser("50% off on all products!");
    }
}
