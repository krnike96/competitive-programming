import java.util.*;
import java.io.*;

public class F2Sort {

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

        long[] nums = new long[n];
        for (int i = 0; i < n; i++) 
            nums[i] = nextLong();

        int[] v = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            v[i] = (nums[i] < (nums[i + 1] << 1)) ? 1 : 0;
        }

        int s = 0;
        int res = 0;
        for (int i = 0; i < k; i++) 
            s += v[i];

        if (s == k) 
            res++;

        for (int i = k; i < n - 1; i++) {
            s += v[i] - v[i - k];
            if (s == k) 
                res++;
        }

        sb.append(res).append("\n");
    }
}