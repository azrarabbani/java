package prog.observer;

/**
 * Created by arabbani on 10/25/16.
 */
//also called publisher
public interface Subject {

    //methods to register and unregister observers
    public void register(Observer obj);
    public void unregister(Observer obj);

    //method to notify observers of change
    public void notifyObservers();

    //method to get updates from subject
    public Object getUpdate(Observer obj);

}
