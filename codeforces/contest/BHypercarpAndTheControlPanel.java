import java.util.*;
import java.io.*;

public class BHypercarpAndTheControlPanel {

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
        int[] a = nextIntArray(n);

        int[] c = new int[n];
        int[] size = new int[n];
        int m = 0;

        for (int i = 0; i < n; i++) {
            if (m == 0 || c[m - 1] != a[i]) {
                c[m] = a[i];
                size[m] = 1;
                m++;
            } else {
                size[m - 1]++;
            }
        }

        if (m == 1) {
            sb.append(1).append('\n');
            return;
        }

        boolean canPlus2 = false;
        for (int i = 0; i < m - 1; i++) {
            if (size[i] >= 2 && size[i + 1] >= 2) {
                canPlus2 = true;
                break;
            }
        }

        if (canPlus2) {
            sb.append(m + 2).append('\n');
            return;
        }

        boolean canPlus1 = false;
        for (int i = 0; i < m; i++) {
            if (size[i] >= 2) {
                boolean opt1 = (i >= 1) && (i == 1 || c[i - 2] != c[i]);
                boolean opt2 = (i <= m - 2) && (i == m - 2 || c[i + 2] != c[i]);
                if (opt1 || opt2) {
                    canPlus1 = true;
                    break;
                }
            }
        }

        if (canPlus1) {
            sb.append(m + 1).append('\n');
        } else {
            sb.append(m).append('\n');
        }
    }
}