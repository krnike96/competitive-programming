import java.util.*;
import java.io.*;

public class GMakeItRound {

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
        long n = nextLong();
        long m = nextLong();
        
        long tmp = n;
        int c2 = 0;
        int c5 = 0;
        
        while (tmp > 0 && (tmp & 1) == 0) {
            c2++;
            tmp >>= 1;
        }
        while (tmp > 0 && tmp % 5 == 0) {
            c5++;
            tmp /= 5;
        }
        
        long k = 1;
        
        while (c2 < c5 && k * 2 <= m) {
            k <<= 1;
            c2++;
        }
        while (c5 < c2 && k * 5 <= m) {
            k *= 5;
            c5++;
        }
        
        while (k * 10 <= m) {
            k *= 10;
        }
        
        if (k > 1) {
            k *= (m / k);
        } else {
            k = m;
        }
        
        sb.append(n * k).append("\n");
    }
}