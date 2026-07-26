import java.util.*;
import java.io.*;

public class CRankSubsequence {

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
        int[] l = new int[n + 1]; 
        int[] r = new int[n + 1];
        int[] u = new int[n + 1];
        int[] v = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            l[i] = nextInt(); 
            r[i] = nextInt(); 
            u[i] = nextInt(); 
            v[i] = nextInt();
        }

        for (int m = n; m >= 1; m--) {
            int[] dp = new int[m + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int j = 1; j <= m; j++) {
                int prevIdx = dp[j - 1];
                if (prevIdx == Integer.MAX_VALUE) 
                    break;

                for (int i = prevIdx + 1; i <= n; i++) {
                    if (j >= l[i] && j <= r[i]) 
                        continue;

                    int rtRank = m - j + 1;
                    if (rtRank >= u[i] && rtRank <= v[i]) 
                        continue;

                    dp[j] = i;
                    break;
                }
            }

            if (dp[m] != Integer.MAX_VALUE) {
                sb.append(m).append("\n");
                return;
            }
        }
        
        sb.append(0).append("\n");
    }
}