import java.util.*;
import java.io.*;

public class C2246BEzraftAndArray {

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

        if (n == 1) {
            sb.append("1\n");
        } else if (n == 2) {
            sb.append("-1\n");
        } else if (n == 4) {
            sb.append("1 9 2 6\n");
        } else if (n == 5) {
            sb.append("12 3 10 20 15\n");
        } else {
            sb.append("1 2");
            long currentVal = 3;
            for (int i = 0; i < n - 2; i++) {
                sb.append(" ").append(currentVal);
                currentVal *= 2;
            }
            sb.append("\n");
        }
    }
}