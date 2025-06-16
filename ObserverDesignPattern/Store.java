package ObserverDesignPattern;

import ObserverDesignPattern.Observable.IphoneObservableImplementation;
import ObserverDesignPattern.Observable.StocksObservable;
import ObserverDesignPattern.Observer.NotificationAlertObserver;
import ObserverDesignPattern.Observer.EmailAlertObserverImplementation;
import ObserverDesignPattern.Observer.MobileAlertObserverImplementation;

public class Store {
    public static void main(String args[]) {
        StocksObservable iphoneStocksObservable = new IphoneObservableImplementation();

        NotificationAlertObserver observer1 = new EmailAlertObserverImplementation("sandip92809mandal@gmail.com",iphoneStocksObservable);

        NotificationAlertObserver observer2 = new EmailAlertObserverImplementation("sandimandal2018@gmail.com", iphoneStocksObservable);

        NotificationAlertObserver observer3 = new MobileAlertObserverImplementation("9330991342", iphoneStocksObservable);

        iphoneStocksObservable.add(observer1);
        iphoneStocksObservable.add(observer2);
        iphoneStocksObservable.add(observer3);

        iphoneStocksObservable.setStockCount(10);

        System.out.println("getting the count " + iphoneStocksObservable.getStockCount());
        
    }
}
