import java.util.*;
import java.io.*;

public class CRiskyTower {

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

    static class SegTree {
        int U;
        int[] cnt;
        long[] sum;
        long[] vals;

        SegTree(long[] vals) {
            this.vals = vals;
            this.U = vals.length;
            cnt = new int[4 * U + 1];
            sum = new long[4 * U + 1];
        }

        void update(int node, int l, int r, int rank, long val) {
            cnt[node]++;
            sum[node] += val;
            if (l == r) return;
            int mid = (l + r) >>> 1;
            if (rank <= mid) {
                update(node << 1, l, mid, rank, val);
            } else {
                update((node << 1) | 1, mid + 1, r, rank, val);
            }
        }

        int query(int node, int l, int r, long targetSum) {
            if (sum[node] < targetSum) {
                return 1_000_000_000;
            }
            if (l == r) {
                long val = vals[l - 1];
                return (int) ((targetSum + val - 1) / val);
            }
            int mid = (l + r) >>> 1;
            int rc = (node << 1) | 1;
            if (sum[rc] >= targetSum) {
                return query(rc, mid + 1, r, targetSum);
            } else {
                long rem = targetSum - sum[rc];
                return cnt[rc] + query(node << 1, l, mid, rem);
            }
        }
    }

    static void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();

        long[] v = nextLongArray(n);

        long[][] a = new long[n][m];
        long[] all = new long[n * m];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = nextLong();
                all[idx++] = a[i][j];
            }
        }

        Arrays.sort(all);
        int u = 0;
        for (int i = 0; i < all.length; i++) {
            if (i == 0 || all[i] != all[i - 1]) {
                all[u++] = all[i];
            }
        }
        long[] vals = Arrays.copyOf(all, u);

        SegTree tree = new SegTree(vals);
        int U = vals.length;
        int ans = m; 

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                int rank = Arrays.binarySearch(vals, a[i][j]) + 1;
                tree.update(1, 1, U, rank, a[i][j]);
            }
            int req = tree.query(1, 1, U, v[i]);
            ans = Math.min(ans, req);
            if (ans == 1) break;
        }

        sb.append(ans).append('\n');
    }
}