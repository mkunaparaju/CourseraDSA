package Week2;

import java.util.Scanner;

public class FibonacciHuge {
    private static long  getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }
        return current % m;
    }
    private static long getFibonacciHuge(long n, long m){
        long pisano = getPisanoPeriod(m);
        long remainder = n %pisano;
        long res = remainder;
        long previous = 0;
        long current = 0;
        for (long i = 1; i < res; i++) {
            remainder = (previous + current) % m;
            previous = current;
            current = remainder;
        }

        return remainder % m;
    }
    private static long getPisanoPeriod(long m) {

        long previous = 0;
        long current = 1;
        long pisanoPeriod = 0;
        for(long i = 0; i < m*m ; i++){
            long temp = (previous+current)%m;
            previous = current;
            current = temp;

            if(previous == 0 && current == 1) {
                pisanoPeriod = i+1;
                break;
            }
        }
        return pisanoPeriod;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}
