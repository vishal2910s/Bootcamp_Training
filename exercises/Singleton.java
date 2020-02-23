class SingletonClass
{
    private static SingletonClass single_instance = null;


    public String str;

    private SingletonClass()
    {
        str = "This string is a member of singleton class." ;
    }

    public static SingletonClass getInstance()
    {
        if (single_instance == null)
            single_instance = new SingletonClass();

        return single_instance;
    }
}

class Singleton
{
    public static void main(String args[])
    {
        SingletonClass x = SingletonClass.getInstance();



        System.out.println("String from x is " + x.str);
        x.str = x.str.toUpperCase();
        System.out.println("String from x is " + x.str);

        SingletonClass y = SingletonClass.getInstance();
        System.out.println("String from y is " + y.str);


    }
}