class demo
{
    static int a = 10;
    int b = 20;

    static class Inner
    {
        static void display()
        {
            System.out.println("Inside static inner class");
        }
    }

    void nonStaticDisplay()
    {
        System.out.println("Inside non static method");
    }

    public static void main(String[] args)
    {
        System.out.println(demo.a);

        demo.Inner.display();
    }
}