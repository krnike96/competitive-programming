import java.util.*;
import java.io.*;

public class BAlwaysChanging {

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

        int c0 = 0, c1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') c0++;
            else c1++;
        }

        if (Math.abs(c0 - c1) > 2) {
            sb.append("-1\n");
            return;
        }

        int[][] dp = new int[2][2];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                int prev01 = dp[0][1];
                int prev11 = dp[1][1];

                dp[0][0] = Math.max(dp[0][0], 1);
                if (prev01 != -1) dp[0][0] = Math.max(dp[0][0], prev01 + 1);
                if (prev11 != -1) dp[1][0] = Math.max(dp[1][0], prev11 + 1);
            } else {
                int prev00 = dp[0][0];
                int prev10 = dp[1][0];

                dp[1][1] = Math.max(dp[1][1], 1);
                if (prev00 != -1) dp[0][1] = Math.max(dp[0][1], prev00 + 1);
                if (prev10 != -1) dp[1][1] = Math.max(dp[1][1], prev10 + 1);
            }
        }

        int maxLen = -1;

        if (dp[0][0] != -1 && Math.abs((c0 - c1) - 1) <= 1) {
            maxLen = Math.max(maxLen, dp[0][0]);
        }

        if (dp[0][1] != -1 && Math.abs((c0 - c1) - 0) <= 1) {
            maxLen = Math.max(maxLen, dp[0][1]);
        }

        if (dp[1][0] != -1 && Math.abs((c0 - c1) - 0) <= 1) {
            maxLen = Math.max(maxLen, dp[1][0]);
        }

        if (dp[1][1] != -1 && Math.abs((c0 - c1) - (-1)) <= 1) {
            maxLen = Math.max(maxLen, dp[1][1]);
        }

        if (maxLen == -1) {
            sb.append("-1\n");
        } else {
            sb.append(n - maxLen).append("\n");
        }
    }
}