import java.util.*;
import java.io.*;

public class AYouDeleteIDelete {

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
        String s = next();
        int n = s.length();

        String bfAlice = null;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                StringBuilder sbT = new StringBuilder();
                sbT.append(s, 0, i).append(s, i + 1, n);
                String T = sbT.toString();

                String bfBob = null;
                int lenT = T.length();
                for (int j = 0; j < lenT; j++) {
                    if (T.charAt(j) == '1') {
                        StringBuilder sbR = new StringBuilder();
                        sbR.append(T, 0, j).append(T, j + 1, lenT);
                        String R = sbR.toString();

                        if (bfBob == null || R.compareTo(bfBob) < 0) {
                            bfBob = R;
                        }
                    }
                }

                if (bfAlice == null || bfBob.compareTo(bfAlice) > 0) {
                    bfAlice = bfBob;
                }
            }
        }

        sb.append(bfAlice).append("\n");
    }
}