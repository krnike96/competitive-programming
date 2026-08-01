import java.util.*;
import java.io.*;

public class CMaximizeTheScore {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char nextChar() throws IOException {
        return next().charAt(0);
    }

    static String nextLine() throws IOException {
        if (st != null && st.hasMoreTokens()) {
            StringBuilder rest = new StringBuilder(st.nextToken());
            while (st.hasMoreTokens())
                rest.append(' ').append(st.nextToken());
            return rest.toString();
        }
        return br.readLine();
    }

    static int[] nextIntArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextInt();
        return arr;
    }

    static long[] nextLongArray(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextLong();
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
        int len = 2 * n;

        int[] a = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            a[i] = nextInt();
        }

        int[] lastOccur = new int[n + 1];
        Arrays.fill(lastOccur, -1);

        long[] dp = new long[len + 1];

        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1];

            int val = a[i];
            if (lastOccur[val] != -1) {
                int j = lastOccur[val];
                long intervalLen = i - j + 1;
                long profit = (intervalLen * intervalLen) - intervalLen;

                dp[i] = Math.max(dp[i], dp[j - 1] + profit);
            }

            lastOccur[val] = i;
        }

        long maxScore = len + dp[len];
        sb.append(maxScore).append("\n");
    }

}