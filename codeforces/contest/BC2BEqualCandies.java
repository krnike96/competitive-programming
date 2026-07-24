import java.util.*;
import java.io.*;

public class BC2BEqualCandies {

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
        int[] a = new int[n];
            
        int minCandies = Integer.MAX_VALUE;
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            totalSum += a[i];
            if (a[i] < minCandies) {
                minCandies = a[i];
            }
        }

        long ans = totalSum - ((long) n * minCandies);
        sb.append(ans).append("\n");
    }
}