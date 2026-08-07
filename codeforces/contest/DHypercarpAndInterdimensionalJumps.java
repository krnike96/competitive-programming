import java.util.*;
import java.io.*;

public class DHypercarpAndInterdimensionalJumps {

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

        long targetSum = x + y;
        long low = 1, high = 200000, k = 1;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (mid * (mid + 1) / 2 <= targetSum) {
                k = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        long S = k * (k + 1) / 2;
        long minP = Math.max(0L, S - y);
        long maxP = Math.min(S, x);

        double pStar = (x - y + S) / 2.0;
        long cand1 = (long) Math.floor(pStar);
        long cand2 = (long) Math.ceil(pStar);

        long bestP = minP;
        long minDist = -1;

        long[] cands = {cand1, cand2};
        for (long p : cands) {
            long clampedP = Math.max(minP, Math.min(maxP, p));
            long q = S - clampedP;
            long dist = (clampedP - x) * (clampedP - x) + (q - y) * (q - y);
            if (minDist == -1 || dist < minDist) {
                minDist = dist;
                bestP = clampedP;
            }
        }

        char[] res = new char[(int) k];
        long currentTarget = bestP;
        for (int w = (int) k; w >= 1; w--) {
            int idx = (int) k - w;
            if (currentTarget >= w) {
                res[idx] = 'X';
                currentTarget -= w;
            } else {
                res[idx] = 'Y';
            }
        }

        sb.append(new String(res)).append('\n');
    }
}