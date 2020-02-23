class Library extends Abstract
{
    public String Library_Name;
    public int Library_id;

    @Override
    void setDetails()
    {
        Library_Name="MY LIBRARY";
        Library_id=124542;
    }

    @Override
    void getDetails()
    {
        System.out.println(Library_Name);
        System.out.println(Library_id);
    }
}
class Librarian implements Lib
{
    public String Librarian_Name;
    public int Librarian_id;
    public String Librarian_address;

    @Override
    public void setDetail() {
        Librarian_Name="Shubham";
        Librarian_id=1234;
        Librarian_address="Noida";

    }
    @Override
    public void getDetail() {
        System.out.println(Librarian_Name);
        System.out.println(Librarian_id);
        System.out.println(Librarian_address);

    }
}
class user extends Abstract
{
    public String user_name;
    public int user_id;
    public String user_address;
    @Override
    public void setDetails() {
        user_name="Vishal";
        user_id=1234565;
        user_address="Delhi";

    }
    @Override
    public void getDetails() {
        System.out.println(user_name);
        System.out.println(user_id);
        System.out.println(user_address);

    }
}
class Book implements Lib
{
    public String Book_Name;
    public String Book_Author;
    public int Book_Id;
    @Override
    public void setDetail() {
        Book_Name="Programming with C";
        Book_Author="Yashwant Kanetkar";
        Book_Id=9869;

    }
    @Override
    public void getDetail() {
        System.out.println(Book_Name);
        System.out.println(Book_Id);
        System.out.println(Book_Author);

    }
}
public class LibraryManagement
{
    public static void main(String arg[])
    {
        Library l=new Library();
        Librarian ll=new Librarian();
        user u=new  user();
        Book b=new Book();
        System.out.println("***LIBRARY****");
        l.setDetails();
        l.getDetails();
        System.out.println("*****LIBRARIAN*****");
        ll.setDetail();
        ll.getDetail();
        System.out.println("*****USER****");
        u.setDetails();
        u.getDetails();
        System.out.println("****BOOK***");
        b.setDetail();
        b.getDetail();
    }
}