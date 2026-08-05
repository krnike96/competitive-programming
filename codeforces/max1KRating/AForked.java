import java.util.*;
import java.io.*;

public class AForked {

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
        long a = nextLong();
        long b = nextLong();
        long kx = nextLong();
        long ky = nextLong();
        long qx = nextLong();
        long qy = nextLong();

        HashSet<Long> kingAttackers = new HashSet<>();
        HashSet<Long> queenAttackers = new HashSet<>();

        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, -1, 1};

        for (int i = 0; i < 4; i++) {
            kingAttackers.add(pack(kx + dx[i] * a, ky + dy[i] * b));
            queenAttackers.add(pack(qx + dx[i] * a, qy + dy[i] * b));

            kingAttackers.add(pack(kx + dx[i] * b, ky + dy[i] * a));
            queenAttackers.add(pack(qx + dx[i] * b, qy + dy[i] * a));
        }

        int forkCount = 0;
        for (long pos : kingAttackers) {
            if (queenAttackers.contains(pos)) {
                forkCount++;
            }
        }

        sb.append(forkCount).append("\n");
    }

    static long pack(long x, long y) {
        return ((x & 0xFFFFFFFFL) << 32) | (y & 0xFFFFFFFFL);
    }
}