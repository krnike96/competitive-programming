import java.util.*;
import java.io.*;

public class BOddQueries {

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
        
        int[] v = nextIntArray(n);
        long[] p = new long[n];
        
        p[0] = v[0];
        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] + v[i];
        }
        
        long s = p[n - 1];
        
        while (q-- > 0) {
            int x = nextInt() - 1; 
            int y = nextInt() - 1; 
            long k = nextLong();
            
            long rem = p[y];
            if (x > 0) {
                rem -= p[x - 1];
            }
            
            long len = (y - x + 1);
            long add = len * k;
            
            long res = (s - rem + add) & 1;
            
            sb.append(res != 0 ? "YES\n" : "NO\n");
        }
    }
}