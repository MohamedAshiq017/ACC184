import java.util.Scanner;

public class Program1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int n = scanner.nextInt();

        int size = 2 * n + 2;
        int[] arr = new int[size];

     
        System.out.println("Enter " + size + " integers for the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] result = findTwoDistinctNumbers(arr);
        System.out.println("The two distinct numbers are: " + result[0] + " " + result[1]);
    }

    private static int[] findTwoDistinctNumbers(int[] arr) {
        int xorResult = 0;
        for (int num : arr) {
            xorResult ^= num;
        }

        int setBit = xorResult & -xorResult;

        int num1 = 0, num2 = 0;

        for (int num : arr) {
            if ((num & setBit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        if (num1 < num2) {
            return new int[]{num1, num2};
        } else {
            return new int[]{num2, num1};
        }
    }
}
