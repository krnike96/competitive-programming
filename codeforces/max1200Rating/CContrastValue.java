import java.util.*;
import java.io.*;

public class CContrastValue {

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

        ArrayList<Integer> uniqueA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (uniqueA.isEmpty() || uniqueA.get(uniqueA.size() - 1) != a[i]) {
                uniqueA.add(a[i]);
            }
        }

        if (uniqueA.size() == 1) {
            sb.append(1).append("\n");
            return;
        }

        int ans = 2; 
        for (int i = 1; i < uniqueA.size() - 1; i++) {
            int prev = uniqueA.get(i - 1);
            int curr = uniqueA.get(i);
            int next = uniqueA.get(i + 1);

            if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                ans++;
            }
        }

        sb.append(ans).append("\n");
    }
}