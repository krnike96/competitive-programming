import java.util.*;
import java.io.*;

public class CMaximizeXorMinimizeOperations {

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
        long x = nextLong();
        long y = nextLong();

        long sum = x + y;
        long targetX = 0;
        boolean tight = true;

        for (int b = 30; b >= 0; b--) {
            long bitS = (sum >> b) & 1L;
            long bitX = (x >> b) & 1L;

            if (!tight) {
                if (bitS == 1) {
                    targetX |= (1L << b);
                }
            } else {
                if (bitS == 1 && bitX == 1) {
                    targetX |= (1L << b);
                } else if (bitS == 0 && bitX == 1) {
                    tight = false;
                }
            }
        }

        long count = x - targetX;
        sb.append(sum).append(" ").append(count).append("\n");
    }
}