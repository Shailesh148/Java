import java.util.Arrays;
public class Array {

    public static void main(String[] args) {
        int[] arr={1,3,4,2,8,9,0,5,7};
        Arrays.sort(arr);
        for(int i=0;i< arr.length;i++)
        {
            if(i!=arr[i]) {
                System.out.println("Missing element in array is " + i);
                break;
            }
        }
    }
}

