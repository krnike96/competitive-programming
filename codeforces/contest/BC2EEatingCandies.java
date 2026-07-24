import java.util.*;
import java.io.*;

public class BC2EEatingCandies {

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
        int q = nextInt();

        Integer[] nums = new Integer[n];

        for(int i = 0; i < n; i++){
            nums[i] = nextInt();
        }

        Arrays.sort(nums, Collections.reverseOrder());

        long[] prefix = new long[n + 1];

        for(int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for(int i = 0; i < q; i++){
            long target = nextLong();

            if(prefix[n] < target){
                sb.append("-1\n");
                continue;
            }

            int lo = 1;
            int hi = n;

            while(lo <= hi){
                int mid = (lo + hi) >>> 1;

                if(prefix[mid] >= target){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }

            sb.append(lo).append("\n");
        }

    }
}