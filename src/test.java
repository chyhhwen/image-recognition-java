
public class test
{
    public test()
    {
        System.out.println(f());
        System.out.println(f(5));
        f1();
        f2(5);
    }
    public static int f()
    {
        int i=5;
        return i;
    }
    public static int f(int i)
    {
        return i;
    }
    public void f1()
    {
        System.out.println("5");
    }
    public void f2(int i)
    {
        System.out.println(i);
    }
    public static void main(String[] args)
    {
        new test();
    }
}