import java.util.concurrent.*;

class Shared
{
    static int count = 0;
}

class MyThread extends Thread
{
    Semaphore sem;
    String threadName;
    public MyThread(Semaphore sem, String threadName)
    {
        super(threadName);
        this.sem = sem;
        this.threadName = threadName;
    }

    @Override
    public void run() {

        // for thread A
        if(this.getName().equals("A"))
        {
            System.out.println("Starting " + threadName);
            try
            {
                System.out.println(threadName + " is waiting for a permit.");

                sem.acquire();

                System.out.println(threadName + " gets a permit.");

                for(int i=0; i < 3; i++)
                {
                    Shared.count++;
                    System.out.println(threadName + ": " + Shared.count);
                    Thread.sleep(10);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }

            System.out.println(threadName + " releases the permit.");
            sem.release();
        }

        else
        {
            System.out.println("Starting " + threadName);
            try
            {

                System.out.println(threadName + " is waiting for a permit.");

                sem.acquire();

                System.out.println(threadName + " gets a permit.");


                for(int i=0; i < 5; i++)
                {
                    Shared.count--;
                    System.out.println(threadName + ": " + Shared.count);


                    Thread.sleep(10);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            System.out.println(threadName + " releases the permit.");
            sem.release();
        }
    }
}

public class SemaphoreUse
{
    public static void main(String args[]) throws InterruptedException
    {
        Semaphore sem = new Semaphore(1);
        MyThread mt1 = new MyThread(sem, "A");
        MyThread mt2 = new MyThread(sem, "B");

        mt1.start();
        mt2.start();
        mt1.join();
        mt2.join();

        System.out.println("count: " + Shared.count);
    }
}