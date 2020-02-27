class VolatileData{
    private volatile int count = 0;
    public int getCount(){
        return count++;
    }

    public void increment(){
        count++;
    }
}


public class Volatile extends Thread{

    private final VolatileData data;
    public Volatile(VolatileData data){
        this.data = data;
    }

    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {
            
            int oldValue = data.getCount();
            System.out.println("Thread "+ Thread.currentThread().getId()+ ": Old Value = "+ oldValue);
            data.increment();
            int newValue = data.getCount();
            System.out.println("Thread "+ Thread.currentThread().getId()+ ": New Value = "+ newValue);
        }
    }

    public static void main(String[] args) {
        VolatileData volatileData = new VolatileData();
        Volatile volatile_1 = new Volatile(volatileData);
        Volatile volatile_2 = new Volatile(volatileData);
        volatile_1.start();
        volatile_2.start();
    }
}