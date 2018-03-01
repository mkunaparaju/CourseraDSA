package Week2;

import java.util.Scanner;

public class Fibonacci {
    private static long calc_fib_naive(int n) {
        if (n <= 1)
            return n;

        return calc_fib_naive(n - 1) + calc_fib_naive(n - 2);
    }
    private static long calc_fib(int n){
        int [] fibArr = new int[n+1];
        for(int i = 0; i <= n; i++){
            if(i <= 1)  {
                fibArr[i] = i;
            }
            else{

                fibArr[i] = fibArr[i-1] + fibArr[i-2];

            }
        }
         return fibArr[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}
