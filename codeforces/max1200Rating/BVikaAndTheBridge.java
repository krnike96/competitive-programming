import java.util.*;
import java.io.*;

public class BVikaAndTheBridge {

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
        int k = nextInt();
        int[] c = nextIntArray(n);

        int[] lastPos = new int[k + 1];
        int[] maxGap1 = new int[k + 1];
        int[] maxGap2 = new int[k + 1];

        for (int i = 1; i <= n; i++) {
            int color = c[i - 1];
            int gap = i - lastPos[color] - 1;
            
            updateGaps(color, gap, maxGap1, maxGap2);
            lastPos[color] = i;
        }

        for (int color = 1; color <= k; color++) {
            int finalGap = (n + 1) - lastPos[color] - 1;
            updateGaps(color, finalGap, maxGap1, maxGap2);
        }

        int res = Integer.MAX_VALUE;
        for (int color = 1; color <= k; color++) {
            int currMaxStep = Math.max(maxGap1[color] / 2, maxGap2[color]);
            res = Math.min(res, currMaxStep);
        }

        sb.append(res).append("\n");
    }

    static void updateGaps(int color, int gap, int[] maxGap1, int[] maxGap2) {
        if (gap > maxGap1[color]) {
            maxGap2[color] = maxGap1[color];
            maxGap1[color] = gap;
        } else if (gap > maxGap2[color]) {
            maxGap2[color] = gap;
        }
    }
}