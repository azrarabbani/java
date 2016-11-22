package prog.observer;

/**
 * Created by arabbani on 10/25/16.
 */
public class Subscriber implements Observer {

    private String name;
    private Subject topic;

    public Subscriber(String nm){
        this.name=nm;
    }
    @Override
    public void onUpdate() {
        String msg = (String) topic.getUpdate(this);
        if(msg == null){
            System.out.println(name+":: No new message");
        }else
            System.out.println(name+":: Consuming message::"+msg);
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic=sub;
    }

}
