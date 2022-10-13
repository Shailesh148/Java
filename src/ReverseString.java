import java.util.*;
class reverse{
    public static void main(String[]abcd)
    {
        String letter;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        letter = sc.nextLine();
        String x[] = letter.split("");
        for(int i=x.length-1;i>=0;i--)
        {
            System.out.print(x[i]);
        }
    }
}