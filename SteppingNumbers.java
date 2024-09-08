import java.util.Scanner;

public class SteppingNumbers

{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start:");
        int start = scanner.nextInt();
        System.out.println("Enter end:");
        int end = scanner.nextInt();
        findSteppingNumbers(start, end);
    }

    private static void findSteppingNumbers(int start, int end) {
        for (int i = 0; i <= 9; i++) {
            checkStepping(start, end, i);
        }
    }

    private static void checkStepping(int start, int end, int num) {
        int[] queue = new int[1000];
        int front = 0;
        int rear = 0;

        queue[rear++] = num;

        while (front < rear) {
            int current = queue[front++];

            if (current >= start && current <= end) {
                System.out.print(current + " ");
            }

            if (current == 0 || current > end) {
                continue;
            }

            int lastDigit = current % 10;

            int nextNum1 = current * 10 + (lastDigit - 1);
            int nextNum2 = current * 10 + (lastDigit + 1);

            if (lastDigit > 0 && nextNum1 <= end) {
                queue[rear++] = nextNum1;
            }

            if (lastDigit < 9 && nextNum2 <= end) {
                queue[rear++] = nextNum2;
            }
        }
    }
}
