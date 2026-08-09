import java.util.*;
import java.io.*;

public class DARibbonForTomorrow {

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

    static final int M = 998244353;
    static final int MAX = 1000005;
    static long[] f = new long[MAX];
    static long[] g = new long[MAX];

    static long pow(long b, long e) {
        long r = 1;
        b %= M;
        while (e > 0) {
            if ((e & 1) == 1) r = (r * b) % M;
            b = (b * b) % M;
            e >>= 1;
        }
        return r;
    }

    static long inv(long n) {
        return pow(n, M - 2);
    }

    static void prep() {
        f[0] = 1;
        g[0] = 1;
        for (int i = 1; i < MAX; i++) {
            f[i] = (f[i - 1] * i) % M;
        }
        g[MAX - 1] = inv(f[MAX - 1]);
        for (int i = MAX - 2; i >= 1; i--) {
            g[i] = (g[i + 1] * (i + 1)) % M;
        }
    }

    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return f[n] * g[r] % M * g[n - r] % M;
    }

    public static void main(String[] args) throws IOException {
        prep();
        int t = nextInt();
        while (t-- > 0) {
            solve();
        }
        System.out.print(sb);
        System.out.flush();
    }

    static void solve() throws IOException {
        int n = nextInt();
        String s = next();

        int[] b = new int[n];
        int sz = 0, c = 0;
        for (int i = 0; i < n; i++) {
            c++;
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                b[sz++] = c;
                c = 0;
            }
        }

        int no = 0, so = 0;
        int ne = 0, se = 0;

        for (int i = 0; i < sz; i++) {
            if (i % 2 == 0) {
                no++;
                so += b[i];
            } else {
                ne++;
                se += b[i];
            }
        }

        long a1 = nCr(so - 1, no - 1);
        long a2 = (ne == 0) ? 1 : nCr(se - 1, ne - 1);

        long ans = (a1 * a2) % M;
        sb.append(ans).append("\n");
    }
}