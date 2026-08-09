import java.util.*;
import java.io.*;

public class BDominoTiles {

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

    static int count(String s, int st) {
        int w = 0;

        boolean ok0 = true;
        for (int i = st; i < s.length(); i += 2) {
            int k = (i - st) / 2;
            char exp = (k % 2 == 0) ? '0' : '1';
            if (s.charAt(i) != '?' && s.charAt(i) != exp) {
                ok0 = false;
                break;
            }
        }
        if (ok0) w++;

        boolean ok1 = true;
        for (int i = st; i < s.length(); i += 2) {
            int k = (i - st) / 2;
            char exp = (k % 2 == 0) ? '1' : '0';
            if (s.charAt(i) != '?' && s.charAt(i) != exp) {
                ok1 = false;
                break;
            }
        }
        if (ok1) w++;

        return w;
    }

    static void solve() throws IOException {
        int n = nextInt();
        String s = next();

        long w0 = count(s, 0);
        long w1 = count(s, 1);

        long ans = (w0 * w1) % 998244353;
        sb.append(ans).append("\n");
    }
}