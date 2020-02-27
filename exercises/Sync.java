public class Sync extends Thread{
    public int count = 0;

    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Inside thread class using sync method" + i);
            incrementCount();
            sychronizedBlock();
        }
        System.out.println("Count = "+count);
    }

    private synchronized void incrementCount() {
        count++;
    }


    private void sychronizedBlock() {
        synchronized(this){
            count++;
        }
    }

    public static void main(String[] args) {
        Sync s1 = new Sync();
        Sync s2 = new Sync();
        s1.start();
        s2.start();
    }
}
