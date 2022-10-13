import java.util.*;
class EvenOdd{
    public static void main(String[]abcd){
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value: ");
        num = sc.nextInt();
        if(num%2==0)
        {
            System.out.println("The given number is even number: " +num);
        }
        else
            System.out.println("The given number is odd number: " +num);
    }
}