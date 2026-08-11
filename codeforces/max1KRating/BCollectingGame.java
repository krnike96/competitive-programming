import java.util.*;
import java.io.*;

public class BCollectingGame {

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
        long[][] a = new long[n][2];

        for(int i = 0; i < n; i++){
            a[i][0] = nextLong();
            a[i][1] = i;
        }

        Arrays.sort(a, (x, y) -> Long.compare(x[0], y[0]));

        long[] pref = new long[n];
        pref[0] = a[0][0];
        for(int i = 1; i < n; i++){
            pref[i] = pref[i - 1] + a[i][0];
        }

        int[] res = new int[n];
        int j = 0;
        
        for(int i = 0; i < n; i++){
            if(j < i) j = i;

            while(j < n- 1 && pref[j] >= a[j + 1][0]) j++;

            int idx = (int) a[i][1];
            res[idx] = j;
        }

        for(int i = 0; i < n; i++){
            sb.append(res[i]).append(i == n - 1 ? "" : " ");
        }

        sb.append("\n");
    }
}