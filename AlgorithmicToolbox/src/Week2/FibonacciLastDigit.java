package Week2;

import java.util.Scanner;

public class FibonacciLastDigit {
    private static double getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        double previous = 0;
        double current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            double tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }
        System.out.println("current" + current);
        return current % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}
