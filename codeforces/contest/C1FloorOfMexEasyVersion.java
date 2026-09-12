import java.util.*;
import java.io.*;

public class C1FloorOfMexEasyVersion {

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

        int[] diff = new int[n + 1];

        for (int k = 1; k <= n; k++) {
            long l = (long) a[k - 1] * k;
            if (l < n) {
                int L = (int) l;
                int R = (int) Math.min(n - 1, l + k - 1);
                diff[L]++;
                diff[R + 1]--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int active = 0;
        for (int i = 0; i < n; i++) {
            active += diff[i];
            if (active == 0) {
                ans.add(i);
            }
        }

        sb.append(ans.size()).append("\n");
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i)).append(i == ans.size() - 1 ? "" : " ");
        }
        sb.append("\n");
    }
}