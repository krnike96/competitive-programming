import java.util.*;
import java.io.*;

public class EScuza {

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
        int q = nextInt();
        
        long[] a = nextLongArray(n);
        
        long[] p = new long[n + 1];
        long[] m = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + a[i];
            m[i + 1] = Math.max(m[i], a[i]);
        }
        
        while (q-- > 0) {
            long k = nextLong();
            
            int low = 1, high = n, ans = 0;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (m[mid] <= k) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            sb.append(p[ans]).append(q == 0 ? "" : " ");
        }
        sb.append("\n");
    }
}