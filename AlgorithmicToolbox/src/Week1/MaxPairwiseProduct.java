package Week1;

import java.io.*;
import java.util.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
       long product = 0;
       long maxHigh = 0;
       long maxLow = 0;
        int highIndex = 0;
       for(int i = 0; i < numbers.length; i++) {
           if (numbers[i] >= maxHigh) {
               maxHigh = numbers[i];
               highIndex = i;
           }
       }
        for(int i = 0; i < numbers.length; i++)  {
            if(numbers[i] >= maxLow && highIndex!= i) maxLow = numbers[i];
        }
        return maxHigh*maxLow;
    }

    static long getMaxPairwiseNaive(int [] numbers )    {
        int result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = numbers[i] * numbers[j];
                }
            }
        return result;
        }

    static void stressTest(int n, int m)    {
       while(true) {
           int random = (int) (Math.random() * n + 1);
           int[] testArr = new int[random];
           for (int i = 0; i < random; i++) {
               testArr[i] = (int) (Math.random() * m + 1);
           }
           long r1 = getMaxPairwiseNaive(testArr);
           long r2 = getMaxPairwiseProduct(testArr);

           if (r1 == r2)
               System.out.println("OK");
           else {
               System.out.println("Wrong answer " + r1 + " " + r2);
               return;
           }
       }
    }
    public static void main(String[] args) {
//        FastScanner scanner = new FastScanner(System.in);
//        int n = scanner.nextInt();
//        int[] numbers = new int[n];
//        for (int i = 0; i < n; i++) {
//            numbers[i] = scanner.nextInt();
//        }
        stressTest(10, 10000);
        //System.out.println(getMaxPairwiseProduct(numbers));
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {

                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}