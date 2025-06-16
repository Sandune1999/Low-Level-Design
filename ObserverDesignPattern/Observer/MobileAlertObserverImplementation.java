package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.StocksObservable;

public class MobileAlertObserverImplementation implements NotificationAlertObserver {
    String mobileNumber;
    StocksObservable observable;

    public MobileAlertObserverImplementation(String mobileNumber, StocksObservable observable) {
        this.mobileNumber = mobileNumber;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMessege(mobileNumber, "product stock came, so hurry up");
    }

    private void sendMessege(String mobileNumber, String msg) {
        System.out.println("msg sent to " + mobileNumber + " with msg as " + msg);
    }
}
