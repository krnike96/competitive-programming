import java.util.*;
import java.io.*;

public class FBinaryStringReconstruction {

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
        int n0 = nextInt();
        int n1 = nextInt();
        int n2 = nextInt();

        if (n1 == 0) {
            if (n0 > 0) {
                for (int i = 0; i <= n0; i++) sb.append('0');
            } else if (n2 > 0) {
                for (int i = 0; i <= n2; i++) sb.append('1');
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i <= n2; i++) {
            sb.append('1');
        }

        for (int i = 0; i <= n0; i++) {
            sb.append('0');
        }

        int rem1 = n1 - 1;
        int flag = 1;

        for (int i = 0; i < rem1; i++) {
            sb.append(flag);
            flag ^= 1;
        }
        
        sb.append("\n");
    }
}