import java.util.*;
import java.io.*;

public class Problem1614B {

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
        int[][] nums = new int[n][2];

        for(int i = 0; i < n; i++){
            nums[i][0] = nextInt();
            nums[i][1] = i + 1;
        }
        
        Arrays.sort(nums, (a, b) -> Integer.compare(b[0], a[0]));

        int[] res = new int[n + 1];
        res[0] = 0;

        long total = 0L;
        int curr = 1;

        for(int i = 0; i < n; i++){
            int freq = nums[i][0];
            int idx = nums[i][1];

            if(i % 2 == 0){
                res[idx] = curr;
                total += 2L * freq * curr;
            }else{
                res[idx] = -curr;
                total += 2L * freq * curr;
                curr++;
            }
        }

        sb.append(total).append("\n");

        for(int i = 0; i <= n; i++){
            sb.append(res[i]).append(i == n ? "" : " ");
        }

        sb.append("\n");
    }
}