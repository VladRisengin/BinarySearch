
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static int arr[] = new int[9];
    public static int desiredNumber;
    public static int middle;

    public static void randomArray() {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void arraySort() {
        Arrays.sort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int enteringTheDesiredNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the desired number ");
        try {
            desiredNumber = sc.nextInt();
        }catch (InputMismatchException e){
            e.printStackTrace();
            System.out.println("Enter the number ");
            return enteringTheDesiredNumber();
        }
        return desiredNumber;
    }

    public static void binarySearch() {
        int arrayLength = arr.length - 1;
        int low = 0, high;
        high = arrayLength;
        boolean found = false;

        while (low <= high) {
            middle = low + (high - low) / 2;

            if (desiredNumber < arr[middle]) {
                high = middle - 1;
            } else if (desiredNumber > arr[middle]) {
                low = middle + 1;
            } else {
                found = true;
                break;
            }
        }

        if(found==true){
            System.out.println("The desired number " +desiredNumber+ " is found by in index "+middle);
        }else{
            System.out.println("The desired number " +desiredNumber+ " is not found");
        }
    }

    public static void main(String[] args) {
        randomArray();
        arraySort();
        enteringTheDesiredNumber();
        binarySearch();
    }
}
