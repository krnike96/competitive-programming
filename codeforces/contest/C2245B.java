import java.util.*;
import java.io.*;

public class C2245B {

    static BufferedReader stReader = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in = new StreamTokenizer(stReader);

    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    static long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }

    static String nextToken() throws IOException {
        in.nextToken();
        return in.sval;
    }

    static String nextLine() throws IOException {
        return stReader.readLine();
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
        long c = nextLong();
        long[] a = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            sum += a[i];
        }

        long base = sum - c * (long) n;

        Arrays.sort(a);

        int limit = n / 2;
        long cur = 0;
        long best = 0;
        for (int i = 0; i < limit; i++) {
            cur += (c - a[i]);
            if (cur > best)
                best = cur;
        }

        long ans = base + best;
        sb.append(ans).append('\n');
    }
}