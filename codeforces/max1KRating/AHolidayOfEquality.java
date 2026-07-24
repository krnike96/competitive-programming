import java.util.*;
import java.io.*;

public class AHolidayOfEquality {

    static BufferedReader stReader = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in = new StreamTokenizer(stReader);
    static int nextInt() throws IOException { in.nextToken(); return (int) in.nval; }
    static long nextLong() throws IOException { in.nextToken(); return (long) in.nval; }
    static double nextDouble() throws IOException { in.nextToken(); return in.nval; }
    static String nextToken() throws IOException { in.nextToken(); return in.sval; }

    // For full lines (e.g. sentences with spaces) - don't mix with the tokenizer mid-problem
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
        int n = nextInt();

        int[] walfare = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            walfare[i] = nextInt();
            max = Math.max(max, walfare[i]);
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            res += (max - walfare[i]);
        }

        sb.append(res).append("\n");
    }
}