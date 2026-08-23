import java.util.*;
import java.io.*;

public class DManhattanCircle {

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
        int m = nextInt();
        
        int ctrRow = -1;
        int ctrCol = -1;
        int maxHashCount = 0;

        for (int i = 1; i <= n; i++) {
            String row = next();
            int currHashCount = 0;
            int firstHashIndex = -1;
            int lastHashIndex = -1;

            for (int j = 0; j < m; j++) {
                if (row.charAt(j) == '#') {
                    currHashCount++;
                    if (firstHashIndex == -1) {
                        firstHashIndex = j + 1;
                    }
                    lastHashIndex = j + 1;
                }
            }

            if (currHashCount > maxHashCount) {
                maxHashCount = currHashCount;
                ctrRow = i;
                ctrCol = (firstHashIndex + lastHashIndex) / 2;
            }
        }

        sb.append(ctrRow).append(" ").append(ctrCol).append("\n");
    }
}