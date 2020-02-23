import java.util.Scanner;
public class WordDone {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 for using While loop and 2 for using do while loop: ");
        int num = input.nextInt();
        String word;
        if (num == 1){
            System.out.println("Please enter the word: ");
            word = input.next();
            while (!word.equals("done")) {
                int len = word.length();
                if(word.charAt(0)==word.charAt(len-1)){
                    System.out.println("first character of the word is equal to its last character.");
                }
                else{
                    System.out.println("first character of the word is not equal to its last character.");
                }
                System.out.println("Please enter the word: ");
                word = input.next();
            }
        }
        else if (num == 2){
            do{
                System.out.println("Please enter the word: ");
                word = input.next();
                int len = word.length();
                if(word.charAt(0)==word.charAt(len-1)){
                    System.out.println("first character of the word is equal to its last character.");
                }
                else{
                    System.out.println("first character of the word is not equal to its last character.");
                }
            }while(!word.equals("done"));
        }
        else{
            System.out.println("Incorrect option");
        }
    }
}