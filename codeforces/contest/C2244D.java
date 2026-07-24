import java.util.*;
import java.io.*;

public class C2244D {

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

        long[] a = new long[n + 1];
        for(int i = 1; i <= n; i++){
            a[i] = nextLong();
        }

        int[] b = new int[m];
        for(int i = 0; i < m; i++){
            b[i] = nextInt();
        }

        Arrays.sort(b);

        long res = 0L;
        int idx = 1;

        for(int i = 0; i < m; i++){
            int k = b[i];
            long currSum = 0L;

            while(idx <= k){
                currSum += a[idx];
                idx++;
            }

            res += Math.abs(currSum);
        }

        long remains = 0L;
        while(idx <= n){
            remains += a[idx];
            idx++;
        }

        res += remains;

        sb.append(res).append("\n");
    }
}