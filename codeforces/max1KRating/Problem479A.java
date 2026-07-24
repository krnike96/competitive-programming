import java.util.*;
import java.io.*;

public class Problem479A {

    static BufferedReader stReader = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in = new StreamTokenizer(stReader);
    static int nextInt() throws IOException { in.nextToken(); return (int) in.nval; }
    static long nextLong() throws IOException { in.nextToken(); return (long) in.nval; }
    static double nextDouble() throws IOException { in.nextToken(); return in.nval; }
    static String nextToken() throws IOException { in.nextToken(); return in.sval; }

    static String nextLine() throws IOException { return stReader.readLine(); }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // int t = nextInt(); 
        // while (t-- > 0) 
            solve();

        System.out.print(sb);
        System.out.flush();
    }

    static void solve() throws IOException {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();

        int r1 = a + b * c;
        int r2 = a * (b + c);
        int r3 = a * b * c;
        int r4 = (a + b) * c;
        int r5 = a + b + c;
        int r6 = a * b + c;

        r4 = Math.max(r4, Math.max(r3, Math.max(r2, Math.max(r1, Math.max(r5, r6)))));

        sb.append(r4).append("\n");
    }
}