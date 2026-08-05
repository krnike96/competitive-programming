import java.util.*;
import java.io.*;

public class AMakeItZero {

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

    // passes on CF
    static void solve() throws IOException {
        int n = nextInt();

        for (int i = 0; i < n; i++) {
            nextInt();
        }

        if (n % 2 == 0) {
            sb.append(2).append("\n");
            sb.append(1).append(" ").append(n).append("\n");
            sb.append(1).append(" ").append(n).append("\n");
        }else {
            sb.append(4).append("\n");
            sb.append(1).append(" ").append(n - 1).append("\n");
            sb.append(1).append(" ").append(n - 1).append("\n");
            sb.append(n - 1).append(" ").append(n).append("\n");
            sb.append(n - 1).append(" ").append(n).append("\n");
        }
    }
}