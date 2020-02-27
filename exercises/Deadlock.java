public class Deadlock {
    String str1 = "hello ";
    String str2 = "world";
    Thread th1 = new Thread(){
        public void run(){
            while(true){
                synchronized(str1){
                    synchronized(str2){
                        System.out.println(str1 + str2);
                    }
                }
            }
        }
    };
    Thread th2 = new Thread(){
        public void run(){
            while(true){
                synchronized(str2){
                    synchronized(str1){
                        System.out.println(str2 + str1);
                    }
                }
            }
        }
    };
    public static void main(String a[]){
        Deadlock dl = new Deadlock();
        dl.th1.start();
        dl.th2.start();
    }
}