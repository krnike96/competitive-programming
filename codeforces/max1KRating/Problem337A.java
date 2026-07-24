import java.util.*;
import java.io.*;

public class Problem337A {

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
        int n = nextInt();
        int m = nextInt();

        int[] nums = new int[m];

        int res = Integer.MAX_VALUE;

        for(int i = 0; i < m; i++){
            nums[i] = nextInt();
        }

        Arrays.sort(nums);

        for(int i = 0; i <= m - n; i++){
            int curr = nums[i + n - 1] - nums[i];
            res = Math.min(res, curr);
        }

        sb.append(res).append("\n");
    }
}