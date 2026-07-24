import java.util.*;
import java.io.*;

public class C2245C {

    static BufferedReader stReader = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in = new StreamTokenizer(stReader);
    static int nextInt() throws IOException { in.nextToken(); return (int) in.nval; }
    static long nextLong() throws IOException { in.nextToken(); return (long) in.nval; }
    static double nextDouble() throws IOException { in.nextToken(); return in.nval; }
    static String nextToken() throws IOException { in.nextToken(); return in.sval; }

    static String nextLine() throws IOException { return stReader.readLine(); }

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
        int k = nextInt();

        if (n == 1) {
            if (k == 1) {
                sb.append("YES\n0\n");
            } else {
                sb.append("NO\n");
            }
            return;
        }

        boolean isPowerOf2 = (n & (n - 1)) == 0;
        int[] f = new int[n];
        boolean possible = false;

        if (isPowerOf2) {
            if (k >= n && k <= 2 * n - 1) {
                possible = true;
                int X = k ^ n;
                f[n - 1] = n;
                f[n - 2] = X;
            }
        } else {
            int L = Integer.highestOneBit(n) << 1;
            if (k < L) {
                possible = true;
                int X = k ^ n;
                if (X <= n - 1) {
                    f[n - 1] = n;
                    f[n - 2] = X;
                } else {
                    int B = Integer.highestOneBit(X);
                    int A = X ^ B;
                    f[n - 1] = n;
                    f[n - 2] = B;
                    f[n - 3] = A;
                }
            }
        }

        if (!possible) {
            sb.append("NO\n");
            return;
        }

        int[] p = new int[n];
        Arrays.fill(p, -1);

        for (int i = 0; i < n; i++) {
            int prev = (i == 0) ? 0 : f[i - 1];
            int curr = f[i];
            if (curr > prev) {
                p[i] = prev;
            }
        }

        int emptyPtr = 0;
        for (int i = 0; i < n; i++) {
            int prev = (i == 0) ? 0 : f[i - 1];
            int curr = f[i];
            if (curr > prev) {
                for (int val = prev + 1; val < curr; val++) {
                    while (p[emptyPtr] != -1) {
                        emptyPtr++;
                    }
                    p[emptyPtr] = val;
                }
            }
        }

        sb.append("YES\n");
        for (int i = 0; i < n; i++) {
            sb.append(p[i]).append(i == n - 1 ? "" : " ");
        }
        sb.append("\n");
    }
}