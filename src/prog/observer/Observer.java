package prog.observer;

/**
 * Created by arabbani on 10/25/16.
 */
//also called subscriber
public interface Observer {

    //method to update the observer, used by subject
    void onUpdate();

    //attach with subject to observe
    void setSubject(Subject sub);
}