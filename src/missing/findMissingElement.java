package missing;

public class findMissingElement {

    public static void main(String[] args) {

        int[] arr1={7,5,6,1,4,2,3,9};
        System.out.println("Missing number from array arr1: "+missingNumber(arr1));
    }

    public static int missingNumber(int[] arr)
    {
        int n=arr.length+1;
        int sum=n*(n+1)/2;
        int restSum=0;
        for (int i = 0; i < arr.length; i++) {
            restSum+=arr[i];
        }
        int missingNumber=sum-restSum;
        return missingNumber;
    }
}

//    sum of n number
//        Find sum of elements present in given array.
//        Subtract (sum of n numbers – sum of elements present in the array).

