import java.util.*;
public class List{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Float> nums = new ArrayList<Float>();
        System.out.println("Enter 5 Float elements: ");
        for (int i = 0; i < 5; i++) {
            nums.add(sc.nextFloat());
        }
        Iterator<Float> iterator = nums.iterator();
        float sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        System.out.println("Sum = "+sum);
    }
}