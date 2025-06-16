package ObserverDesignPattern.Observable;

import ObserverDesignPattern.Observer.NotificationAlertObserver;

public interface StocksObservable {
    void add(NotificationAlertObserver obj);
    void remove(NotificationAlertObserver obj);
    void notifyObserver();
    void setStockCount(int newStockAdded);
    int getStockCount();
}
