import java.util.*;
import java.io.*;

public class ETreasureMapDestructionConstructiveVersion {

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

    // passes on CF
    static void solve() throws IOException {
        int n = nextInt();
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = nextInt();
        }

        int[] diff = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            if (b[i] > 0) {
                int l = Math.max(1, i - b[i] + 1);
                int r = Math.min(n, i + b[i] - 1);
                if (l <= r) {
                    diff[l]++;
                    diff[r + 1]--;
                }
            }
        }

        boolean[] inP = new boolean[n + 1];
        int curr = 0;
        int countP = 0;
        for (int i = 1; i <= n; i++) {
            curr += diff[i];
            if (curr == 0) {
                inP[i] = true;
                countP++;
            }
        }

        boolean possible = (countP > 0);

        if (possible) {
            for (int i = 1; i <= n; i++) {
                if (b[i] == 0) {
                    if (!inP[i]) {
                        possible = false;
                        break;
                    }
                } else if (b[i] > 0) {
                    boolean ok = false;
                    if (i - b[i] >= 1 && inP[i - b[i]]) {
                        ok = true;
                    }
                    if (i + b[i] <= n && inP[i + b[i]]) {
                        ok = true;
                    }
                    if (!ok) {
                        possible = false;
                        break;
                    }
                }
            }
        }

        if (!possible) {
            sb.append("-1\n");
        } else {
            for (int i = 1; i <= n; i++) {
                sb.append(inP[i] ? '1' : '0');
            }
            sb.append("\n");
        }
    }
}