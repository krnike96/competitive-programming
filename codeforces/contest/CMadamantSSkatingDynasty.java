import java.util.*;
import java.io.*;

public class CMadamantSSkatingDynasty {

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
    static final int MOD = 998244353;

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) 
            solve();
        
        System.out.print(sb);
        System.out.flush();
    }

    static void solve() throws IOException {
        int n = nextInt();
        long[] a = nextLongArray(n);
        if (n == 1) {
            sb.append(0).append('\n');
            return;
        }

        Arrays.sort(a);

        long[] s = new long[n];
        s[n - 1] = a[n - 1] % MOD;
        for (int i = n - 2; i >= 0; i--) {
            s[i] = (s[i + 1] + a[i]) % MOD;
        }

        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            int k = n - 1 - i;
            long invK = power(k, MOD - 2);
            long avg = (s[i + 1] * invK) % MOD;
            long diff = (avg - (a[i] % MOD) + MOD) % MOD;
            sum = (sum + diff) % MOD;
        }

        long fact = 1;
        for (int i = 1; i < n; i++) {
            fact = (fact * i) % MOD;
        }

        long ans = (sum * fact) % MOD;
        sb.append(ans).append('\n');
    }

    static long power(long b, long e) {
        long r = 1;
        b %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) r = (r * b) % MOD;
            b = (b * b) % MOD;
            e >>= 1;
        }
        return r;
    }
}