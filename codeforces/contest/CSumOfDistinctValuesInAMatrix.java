import java.util.*;
import java.io.*;

public class CSumOfDistinctValuesInAMatrix {

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

    static class Item {
        int val;
        int type;
        Item(int val, int type) {
            this.val = val;
            this.type = type;
        }
    }

    static void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int x = nextInt();
        int y = nextInt();

        int[] a = nextIntArray(x);
        int[] b = nextIntArray(y);

        List<Item> items = new ArrayList<>();
        int i = x - 1, j = y - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0 && a[i] == b[j]) {
                items.add(new Item(a[i], 2));
                i--;
                j--;
            } else if (j < 0 || (i >= 0 && a[i] > b[j])) {
                items.add(new Item(a[i], 0));
                i--;
            } else {
                items.add(new Item(b[j], 1));
                j--;
            }
        }

        long ans1 = solveGreedy(items, Math.min(n, x), Math.min(m - 1, y));
        long ans2 = solveGreedy(items, Math.min(n - 1, x), Math.min(m, y));

        sb.append(Math.max(ans1, ans2)).append('\n');
    }

    static long solveGreedy(List<Item> items, int k, int l) {
        if (k < 0 || l < 0) return 0;
        int nA = 0, nB = 0, nAB = 0;
        long sum = 0;

        for (Item item : items) {
            if (item.type == 0) {
                if (nA + 1 <= k && nA + 1 + nB + nAB <= k + l) {
                    nA++;
                    sum += item.val;
                }
            } else if (item.type == 1) {
                if (nB + 1 <= l && nA + nB + 1 + nAB <= k + l) {
                    nB++;
                    sum += item.val;
                }
            } else {
                if (nA + nB + nAB + 1 <= k + l) {
                    nAB++;
                    sum += item.val;
                }
            }
        }
        return sum;
    }
}