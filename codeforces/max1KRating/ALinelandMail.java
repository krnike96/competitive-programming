import java.util.*;
import java.io.*;

public class ALinelandMail {

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
        // int t = nextInt();
        // while (t-- > 0) 
            solve();
        
        System.out.print(sb);
        System.out.flush();
    }

    static void solve() throws IOException {
        int n = nextInt();
        int[] x = nextIntArray(n);

        for (int i = 0; i < n; i++) {
            int minCost = 0;
            int maxCost = 0;

            if (i == 0) {
                minCost = x[1] - x[0];
                maxCost = x[n - 1] - x[0];
            } else if (i == n - 1) {
                minCost = x[n - 1] - x[n - 2];
                maxCost = x[n - 1] - x[0];
            } else {
                minCost = Math.min(x[i] - x[i - 1], x[i + 1] - x[i]);
                maxCost = Math.max(x[i] - x[0], x[n - 1] - x[i]);
            }

            sb.append(minCost).append(" ").append(maxCost).append("\n");
        }
    }
}