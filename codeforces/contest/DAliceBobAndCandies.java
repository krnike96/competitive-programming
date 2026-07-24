import java.util.*;
import java.io.*;

public class DAliceBobAndCandies {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException { return Integer.parseInt(next()); }
    static long nextLong() throws IOException { return Long.parseLong(next()); }
    static double nextDouble() throws IOException { return Double.parseDouble(next()); }
    static char nextChar() throws IOException { return next().charAt(0); }

    static String nextLine() throws IOException {
        if (st != null && st.hasMoreTokens()) {
            StringBuilder rest = new StringBuilder(st.nextToken());
            while (st.hasMoreTokens()) rest.append(' ').append(st.nextToken());
            return rest.toString();
        }
        return br.readLine();
    }

    static int[] nextIntArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = nextInt();
        return arr;
    }

    static long[] nextLongArray(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = nextLong();
        return arr;
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) 
            solve();
        
        System.out.print(sb);
        System.out.flush();
    }

    static void solve() throws IOException {
        int n = nextInt();
        int[] a = nextIntArray(n);

        int l = 0;
        int r = n - 1;
        int m = 0;
        int totA = 0; 
        int totB = 0;
        int prev = 0;

        while (l <= r) {
            int cur = 0;
            if (m % 2 == 0) {
                while (l <= r && cur <= prev) {
                    cur += a[l];
                    l++;
                }
                totA += cur;
            } else {
                while (l <= r && cur <= prev) {
                    cur += a[r];
                    r--;
                }
                totB += cur;
            }
            prev = cur;
            m++;
        }

        sb.append(m).append(" ").append(totA).append(" ").append(totB).append("\n");
    }
}