import java.util.*;
class factorial{
    public static void main(String[]abcd){
        int fact=1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value: ");
        int num = sc.nextInt();
        for(int i=1;i<=num;i++)
        {
            fact=fact*i;
        }
        System.out.println("the factorial of given number is: " +fact);
    }

}