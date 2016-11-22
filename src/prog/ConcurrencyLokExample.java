package prog;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by arabbani on 11/11/15.
 */
public class ConcurrencyLokExample implements Runnable{

    private Object resource;
    private Lock lock;

    public ConcurrencyLokExample(Object r){
        this.resource = r;
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
//        try {
//            if(lock.lockInterruptibly();tryLock(10, TimeUnit.SECONDS)){
//             //obj.dosomething();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }finally{
//            //release lock
//            lock.unlock();
//        }
//        resource.doLogging();
    }

}