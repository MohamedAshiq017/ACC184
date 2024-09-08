import java.util.Scanner;

public class Program4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the ticket price:");
        String ticketPrice = scanner.nextLine();
        
        System.out.print("Enter the number of digits to remove:");
        int k = scanner.nextInt();
        
        scanner.close();
        
        String result = minimizePrice(ticketPrice, k);
        System.out.println(result);
    }

    public static String minimizePrice(String price, int k) {
        int n = price.length();
        StringBuilder sb = new StringBuilder(price);
        
        for (int i = 0; i < k; i++) {
            int len = sb.length();
            int j = 0;
            while (j < len - 1 && sb.charAt(j) <= sb.charAt(j + 1)) {
                j++;
            }
            sb.delete(j, j + 1);
        }

        String minimized = sb.toString();
        if (minimized.isEmpty()) {
            return "0";
        }

        int start = 0;
        while (start < minimized.length() && minimized.charAt(start) == '0') {
            start++;
        }
        minimized = minimized.substring(start);
        System.out.print("Final price:");
        return minimized.isEmpty() ? "0" : minimized;
    }
}
