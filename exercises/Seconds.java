import java.util.Scanner;
public class Seconds {
    public static void main(String[] args) {

        System.out.print("Please enter the number of seconds: ");
        Scanner input = new Scanner(System.in);
        int sec = input.nextInt();

        int days = sec / 86400;
        int dd = sec % 86400;
        int hours = dd / 3600;
        int hh = dd % 3600;
        int minutes = hh / 60;
        int seconds = hh % 60;

        System.out.print(sec + " seconds is " + days + " days, " + hours + " hours, " + minutes + " minutes, and " + seconds + " seconds.");
    }
}

