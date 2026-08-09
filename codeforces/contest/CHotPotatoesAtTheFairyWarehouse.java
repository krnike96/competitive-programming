import java.util.*;
import java.io.*;

public class CHotPotatoesAtTheFairyWarehouse {

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
        long k = nextLong();
        String s = next();

        int len = 2 * n;
        int r = 0, b = 0;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                int nextIdx = (i + 1) % len;
                int finalPos;

                if (s.charAt(nextIdx) == '0') {
                    finalPos = nextIdx + 1;
                } else {
                    finalPos = i + 1;
                }

                if (finalPos % 2 == 0) {
                    r++;
                } else {
                    b++;
                }
            }
        }

        sb.append(r).append(" ").append(b).append("\n");
    }
}