import java.util.Scanner;
public class StringSortingWithoutStringMethods {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str = input.nextLine();
        System.out.println("Before Sorting:" + str);
        str=str.toLowerCase();
        int j = 0;
        char temp = 0;
        char[] chars = str.toCharArray();
        for(int i=0; i < chars.length; i++) {
            for(j=0; j < chars.length; j++) {
                if(chars[j] > chars[i]) {
                    temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        System.out.print("After Sorting: ");
        for(int k=0; k < chars.length; k++) {
            System.out.print(chars[k]);
        }
    }
}