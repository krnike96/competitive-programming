import java.util.*;
import java.io.*;

public class C2246AFarmpiggieAndSubsetSum {

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

        if (n == 2) {
            sb.append("2 1\n");
        } else if (n == 4) {
            sb.append("2 3 4 1\n");
        } else if (n == 6) {
            sb.append("5 4 6 2 1 3\n");
        } else {
            for (int i = 1; i <= n; i++) {
                if (i % 2 != 0) {
                    sb.append(i + 1).append(" ");
                } else {
                    sb.append(i - 1).append(" ");
                }
            }
            sb.append("\n");
        }
    }
}