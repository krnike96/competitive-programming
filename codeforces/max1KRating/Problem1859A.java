import java.util.*;
import java.io.*;

public class Problem1859A {

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
    
    // fails here but passes the testcases
    static void solve() throws IOException {
        int n = nextInt();
        int[] nums = new int[n];

        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();

        int max = Integer.MIN_VALUE;;
        for(int i = 0; i < n; i++){
            nums[i] = nextInt();
            if(nums[i] > max)
                max = nums[i];
        }

        for(int i = 0; i < n; i++){
            if(nums[i] == max)
                c.add(nums[i]);
            else
                b.add(nums[i]);
        }

        if(b.size() == 0){
            sb.append("-1\n");
            return;
        }

        sb.append(b.size()).append(" ").append(c.size()).append("\n");

        for(int x : b){
            sb.append(x).append(" ");
        }

        sb.append("\n");

        for(int x : c){
            sb.append(x).append(" ");
        }

        sb.append("\n");
    }
}