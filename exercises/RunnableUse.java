class Runner1 implements Runnable{

    @Override
    public void run(){

        for (int i = 0; i < 10; i++) {
            System.out.println("Inside thread class in Runnable "+i);
        }
    }
}


class Runner extends Thread{
    
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Inside Thread Class "+i);
        }
    }
}


public class RunnableUse{
    public static void main(String[] args) {
        Runner r = new Runner();
        r.start();
        Thread t = new Thread(new Runner1());
        Thread t1 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Inside thread class in anonymous "+i);
                }                
            }
        });
        t1.start();
        t.start();
    }
}