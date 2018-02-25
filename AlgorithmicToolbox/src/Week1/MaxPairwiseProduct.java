package Week1;

import java.io.*;
import java.util.*;

public class MaxPairwiseProduct {
    static int getMaxPairwiseProduct(int[] numbers) {
       int product = 0;
       int maxHigh = 0;
       int maxLow = 0;

       for(int i = 0; i < numbers.length; i++)  {
           if(numbers[i] >= maxHigh) maxHigh = numbers[i];
       }


        for(int i = 0; i < numbers.length; i++)  {
            if(numbers[i] >= maxLow && maxHigh != maxLow) maxLow = numbers[i];
        }

        return maxHigh*maxHigh;
    }
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
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