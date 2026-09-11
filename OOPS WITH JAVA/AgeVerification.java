import java.util.scanner;
public class AgeVerification{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int age=sc.nextInt();
        try{
        ageCheck(age);}
        catch(InvalidAgeException e)
        {
            System.out.println(e);
        }
    }
    static void ageCheck(int a) throws InvalidAgeException
    {
        if(a<18) throw new InvalidAgeException("Age is invalid");
        System.out.println(x: "eligible to vote");
    }
    }
    class InvalidAgeException extends Exception //checked exception
    {
        InvalidAgeException(String msg)
        {
            super(msg);
        }
    }
}