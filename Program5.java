import java.util.Scanner;

public class Program5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of toys:");
        int n = scanner.nextInt();
        int[] prices = new int[n];

        System.out.println("Enter the prices of the toys:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        System.out.println("Enter the budget:");
        int money = scanner.nextInt();

        scanner.close();

        int result = getMaxToys(prices, money);
        
        System.out.println("Max number of toyss can be purchased:"
        +result);
    }

    public static int getMaxToys(int[] prices, int money) {
        int maxToys = 0;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < prices.length; end++) {
            currentSum += prices[end];

            while (currentSum > money) {
                currentSum -= prices[start];
                start++;
            }

            maxToys = Math.max(maxToys, end - start + 1);
        }

        return maxToys;
    }
}
