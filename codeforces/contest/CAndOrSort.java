import java.util.*;
import java.io.*;

public class CAndOrSort {

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
        String s = next();

        if (s.charAt(0) == '1') {
            int zeros = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') zeros++;
            }
            sb.append(zeros).append("\n");
            return;
        }

        int p = -1;
        int totalZeros = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                if (p == -1) p = i + 1;
            } else {
                totalZeros++;
            }
        }

        if (p == -1) {
            sb.append(0).append("\n");
            return;
        }

        int res = n;
        int prefOnes = 0;

        for (int k = 1; k <= n; k++) {
            if (s.charAt(k - 1) == '1') {
                prefOnes++;
            }

            if (k >= p - 1) {
                int prefZeros = k - prefOnes;
                int suffZeros = totalZeros - prefZeros;
                int currOps = prefOnes + suffZeros;
                res = Math.min(res, currOps);
            }
        }

        sb.append(res).append("\n");
    }
}