import java.util.*;
import java.io.*;

public class BC2DXSum {

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

        int[][] grid = new int[n][m];

        long[] diaA = new long[n + m + 2];
        long[] diaB = new long[n + m + 2];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = nextInt();

                diaA[i - j + m] += grid[i][j];
                diaB[i + j] += grid[i][j];
            }
        }

        long res = 0L;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                long currSum = diaA[i - j + m] + diaB[i + j] - grid[i][j];
                if(currSum > res)
                    res = currSum;
            }
        }

        sb.append(res).append("\n");
    }
}