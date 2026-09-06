import java.util.*;
import java.io.*;

public class RemoveAndAppend {

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
        // int t = nextInt();
        // while (t-- > 0) 
            solve();
        
        System.out.print(sb);
        System.out.flush();
    }

    static void solve() throws IOException {
        int n = nextInt();
        int q = nextInt();
        int[] p = nextIntArray(n);

        int[] prev = new int[n + 1];
        int[] next = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (i > 0) prev[p[i]] = p[i - 1];
            if (i < n - 1) next[p[i]] = p[i + 1];
        }

        int head = p[0];
        int tail = p[n - 1];

        for (int k = 0; k < q; k++) {
            int val = nextInt();
            if (val == tail) continue;

            int pr = prev[val];
            int nx = next[val];

            if (val == head) {
                head = nx;
                prev[head] = 0;
            } else {
                next[pr] = nx;
                prev[nx] = pr;
            }

            next[tail] = val;
            prev[val] = tail;
            next[val] = 0;
            tail = val;
        }

        int curr = head;
        while (curr != 0) {
            sb.append(curr).append(' ');
            curr = next[curr];
        }
    }
}