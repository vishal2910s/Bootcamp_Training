import java.util.Scanner;
class bank{
    double rateofinterest;
    public double getDetails(){
        return rateofinterest;
    }
    public void setDetails(double a){ this.rateofinterest = a;} 
}
class BOI extends bank{
    String firstName;
    String secondName;
    public void setName(String fName,String sName){
        this.firstName = fName;
        this.secondName = sName;
        
    }
}
class SBI extends bank{
    String firstName;
    String secondName;
    public void setName(String fName,String sName){
        this.firstName = fName;
        this.secondName = sName;
        
    }
}
class ICICI extends bank{
    String firstName;
    String secondName;
    public void setName(String fName,String sName){
        this.firstName = fName;
        this.secondName = sName;
        
    }
}

public class BankClass {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the Name of Bank ");
      String bankName = sc.nextLine();
      System.out.println("Enter your firstName");
      String fName = sc.nextLine();
      System.out.println("Enter your lastName");
      String lName = sc.nextLine();
      
      if(bankName.equals("BOI")){
        BOI obj = new BOI();
      obj.setName(fName,lName);
      obj.setDetails(7);
      System.out.println("Rate of interest= "+obj.getDetails());
      }
      else if (bankName.equals("SBI")){
          SBI obj = new SBI();
      obj.setName(fName,lName);
      obj.setDetails(6.9);
      System.out.println("Rate of interest= "+obj.getDetails());
      }
      else if(bankName.equals("ICICI")){
          ICICI obj = new ICICI();
      obj.setName(fName,lName);
      obj.setDetails(7.69);
      System.out.println("Rate of interest= "+obj.getDetails());
      }
      
      System.out.println("Mr/Mrs "+fName+" "+lName+" Account successfully opened in " + bankName + " bank");
    }
}
