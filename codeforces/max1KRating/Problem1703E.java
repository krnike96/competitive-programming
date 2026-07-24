import java.util.*;
import java.io.*;

public class Problem1703E {

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
        // nextLine(); // uncomment to pass in CF

        int[][] nums = new int[n][n];

        for(int i = 0; i < n; i++){
            String line = nextLine();
            for(int j = 0; j < n; j++){
                nums[i][j] = line.charAt(j) - '0';
            }
        }

        int res = 0;

        for(int i = 0; i < n / 2; i++){
            for(int j = 0; j < (n + 1) / 2; j++){
                int sum = (nums[i][j] + nums[j][n - 1 - i] + nums[n - 1 - i][n - 1 - j] + nums[n - 1 - j][i]);

                if(sum == 1 || sum == 3)
                    res++;
                else if(sum == 2)
                    res += 2;
            }
        }

        sb.append(res).append("\n");
    }
}