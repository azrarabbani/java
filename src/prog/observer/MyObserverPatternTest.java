package prog.observer;

/**
 * Created by arabbani on 10/25/16.
 */

public class MyObserverPatternTest {

    public static void main(String[] args) {
        //create subject
        Publisher topic = new Publisher();

        //create observers
        Observer obj1 = new Subscriber("Obj1");
        Observer obj2 = new Subscriber("Obj2");
        Observer obj3 = new Subscriber("Obj3");

        //register observers to the subject
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        //attach observer to subject
        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);

        //check if any update is available
        obj1.onUpdate();

        //now send message to subject
        topic.publish("New Message");
    }

}
