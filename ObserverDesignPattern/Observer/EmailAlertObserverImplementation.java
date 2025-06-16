package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.StocksObservable;

public class EmailAlertObserverImplementation implements NotificationAlertObserver {
    String emailId;
    StocksObservable observable;

    public EmailAlertObserverImplementation(String emailId, StocksObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMail(emailId, "product stock of came, so hurry up");
    }

    private void sendMail(String emailId, String msg) {
        System.out.println("mail sent to " + emailId + " with msg as :- " + msg);
    }
}
