class Demo{

}
public class ExceptionExample {
    public static void main(String args[]) {
        Demo obj =new Demo();
        try
        {
            Class.forName("ToTheNew");
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }
}