import java.util.*;
import java.io.*;

public class BAtMost3JudgeVer {

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
        int w = nextInt();

        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = nextInt();
        }

        boolean[] set = new boolean[w + 1];
        int res = 0;
        for(int i = 0; i < n; i++){
            int s = nums[i];
            if(s <= w){
                set[s] = true;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int s = nums[i] + nums[j];
                if(s <= w){
                    set[s] = true;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    int s = nums[i] + nums[j] + nums[k];
                    if(s <= w){
                        set[s] = true;
                    }
                }
            }
        }

        for(int i = 1; i <= w; i++)
            if(set[i])
                res++;

        sb.append(res).append(" ");
    }
}