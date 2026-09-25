import java.util.*;
import java.io.*;

public class CGcdTreasury {

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

    static int[][] divs = new int[300001][];
    static long[] sum = new long[300001];
    static long[] S = new long[300001];
    static int[] uniq = new int[300001];
    static int[] modD = new int[300001];

    static void init() {
        int[] deg = new int[300001];
        for (int i = 1; i <= 300000; i++) {
            for (int j = i; j <= 300000; j += i) {
                deg[j]++;
            }
        }
        for (int i = 1; i <= 300000; i++) {
            divs[i] = new int[deg[i]];
        }
        int[] ptr = new int[300001];
        for (int i = 1; i <= 300000; i++) {
            for (int j = i; j <= 300000; j += i) {
                divs[j][ptr[j]++] = i;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        int t = nextInt();
        while (t-- > 0) 
            solve();
        
        System.out.print(sb);
        System.out.flush();
    }

    static void solve() throws IOException {
        int n = nextInt();
        int x = nextInt();

        int u = 0;
        for (int i = 0; i < n; i++) {
            int v = nextInt();
            if (sum[v] == 0) {
                uniq[u++] = v;
            }
            sum[v] += v;
        }

        long ans = 0;
        int m = 0;

        for (int i = 0; i < u; i++) {
            int v = uniq[i];
            long sv = sum[v];
            for (int d : divs[v]) {
                if (d > 1 && x % d == 0) {
                    if (S[d] == 0) {
                        modD[m++] = d;
                    }
                    S[d] += sv;
                    if (S[d] > ans) {
                        ans = S[d];
                    }
                }
            }
        }

        sb.append(ans).append("\n");

        for (int i = 0; i < u; i++) {
            sum[uniq[i]] = 0;
        }
        for (int i = 0; i < m; i++) {
            S[modD[i]] = 0;
        }
    }
}