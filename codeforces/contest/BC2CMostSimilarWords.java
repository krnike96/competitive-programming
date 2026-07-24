import java.util.*;
import java.io.*;

public class BC2CMostSimilarWords {

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
        int m = nextInt();

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = nextToken();
        }

        int minTotalDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int currentDiff = 0;
                
                for (int k = 0; k < m; k++) {
                    currentDiff += Math.abs(words[i].charAt(k) - words[j].charAt(k));
                }

                if (currentDiff < minTotalDiff) {
                    minTotalDiff = currentDiff;
                }
            }
        }

        sb.append(minTotalDiff).append("\n");
    }
}
