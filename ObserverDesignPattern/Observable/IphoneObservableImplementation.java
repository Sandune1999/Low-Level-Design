package ObserverDesignPattern.Observable;

import java.util.ArrayList;
import java.util.List;

import ObserverDesignPattern.Observer.NotificationAlertObserver;

public class IphoneObservableImplementation implements StocksObservable {
    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stackCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(NotificationAlertObserver observer:observerList) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if(stackCount == 0) {
            notifyObserver();
        }

        stackCount = newStockAdded;
    }

    @Override
    public int getStockCount() {
        return stackCount;
    }
}
