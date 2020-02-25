import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employee{
    int age, salary;
    String name;

    public Employee(int age, String name, int salary){
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

   public String toString(){
        return "age= "+this.age+ " name= "+ this.name+ " salary "+this.salary;
    }
}

class SortBySalary implements Comparator<Employee>
{
    public int compare(Employee a, Employee b){
        if(b.salary > a.salary)
            return 1;
        else
            return -1;
    }
}


class EmployeeSort{
    public static void main(String[] args) {
        ArrayList<Employee> ar = new ArrayList<Employee>();
        ar.add(new Employee(20, "Vishal", 10000));
        ar.add(new Employee(20, "Pulkit", 12300));
        ar.add(new Employee(20, "Mukesh", 51010));

        System.out.println("Unsorted");
        for(int i=0; i <ar.size(); i++){
            System.out.println(ar.get(i));
        }

        Collections.sort(ar, new SortBySalary());

        System.out.println("\nSorted by highest Salary");
        for (int i = 0; i < ar.size(); i++) {
            System.out.println(ar.get(i));
        }
    }
}