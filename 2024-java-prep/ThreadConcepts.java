import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

public class ThreadConcepts extends Thread {
    public static void main(String[] args) throws Throwable {

        Runnable myrun= new Runnable() {
            @Override
            public void run() {
                System.out.println("my runnable run");
                System.out.println(Thread.currentThread().getName());
            }
        };
        //creating thread by runnable
        Thread t= new Thread(myrun);
        t.start();

        // Creating Thread by extending Thread class
        Dummy d=new Dummy();
        Thread t2= new Thread(d);
        t2.start();

        // creating Thread by callable using Executors
        Callable mycallable= new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("my call method");
                System.out.println(Thread.currentThread().getName());
                return "hello";
            }
        };

         // below method to create thread and run callable
      Executors.newFixedThreadPool(1).submit(mycallable).get();  // without get method it returns Future Obj
    // Executors.newCachedThreadPool().submit(mycallable).get();
     //Executors.newScheduledThreadPool()
     //Executors.newSingleThreadExecutor()


       // Completable feature example
        CompletableFuture cf= CompletableFuture.supplyAsync(()->{
           System.out.println("my completable feature::"+ Thread.currentThread().getName());
           return "hello cf";
        }).thenApply(x->{
           System.out.println("inside apply ::"+Thread.currentThread().getName() );
            return x.length();
       });

        System.out.println(Thread.currentThread().getName());



    }
    // Below thread class overrided method when we extend thread class
    @Override
    public void run() {
        System.out.println("my run");
        System.out.println(Thread.currentThread().getName());
    }

}
