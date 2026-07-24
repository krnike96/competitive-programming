import java.util.*;
import java.io.*;

public class C2245A {

    static BufferedReader stReader = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in = new StreamTokenizer(stReader);
    static int nextInt() throws IOException { in.nextToken(); return (int) in.nval; }
    static long nextLong() throws IOException { in.nextToken(); return (long) in.nval; }
    static double nextDouble() throws IOException { in.nextToken(); return in.nval; }
    static String nextToken() throws IOException { in.nextToken(); return in.sval; }

    static String nextLine() throws IOException { return stReader.readLine(); }

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
        long c = nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextLong();
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;

        // Monotonic stack tracking active elements
        int[] stackIdx = new int[n + 5];
        long[] stackDiff = new long[n + 5];
        long[] stackVal = new long[n + 5];
        long[] stackMaxVal = new long[n + 5];
        int top = 0;

        for (int i = 0; i < n; i++) {
            // Option 1: Treat a[i] as a singleton
            dp[i + 1] = dp[i] + a[i] - c;

            long maxDiff = Long.MIN_VALUE;
            boolean popped = false;

            // Option 2 (Case 1): Match with active elements smaller than or equal to a[i]
            while (top > 0 && a[stackIdx[top - 1]] <= a[i]) {
                top--;
                maxDiff = Math.max(maxDiff, stackDiff[top]);
                popped = true;
            }

            if (popped) {
                dp[i + 1] = Math.max(dp[i + 1], dp[i] + a[i] - c + maxDiff);
            }

            // Option 2 (Case 2): Match with active elements strictly larger than a[i]
            if (top > 0) {
                dp[i + 1] = Math.max(dp[i + 1], dp[i] - c + stackMaxVal[top - 1]);
            }

            // Push current index onto the stack
            long diff = dp[i] - dp[i + 1];
            long val = diff + a[i];

            stackIdx[top] = i;
            stackDiff[top] = diff;
            stackVal[top] = val;
            stackMaxVal[top] = (top == 0) ? val : Math.max(stackMaxVal[top - 1], val);
            top++;
        }

        sb.append(dp[n]).append("\n");
    }
}