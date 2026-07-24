import java.util.*;
import java.io.*;

public class DBalancedRound {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException { return Integer.parseInt(next()); }
    static long nextLong() throws IOException { return Long.parseLong(next()); }
    static double nextDouble() throws IOException { return Double.parseDouble(next()); }
    static char nextChar() throws IOException { return next().charAt(0); }

    static String nextLine() throws IOException {
        if (st != null && st.hasMoreTokens()) {
            StringBuilder rest = new StringBuilder(st.nextToken());
            while (st.hasMoreTokens()) rest.append(' ').append(st.nextToken());
            return rest.toString();
        }
        return br.readLine();
    }

    static int[] nextIntArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = nextInt();
        return arr;
    }

    static long[] nextLongArray(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = nextLong();
        return arr;
    }

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
        int k = nextInt();

        int[] nums = nextIntArray(n);

        if(n == 1){
            sb.append("0\n");
            return;
        }
        // 1 3 5 12 12 17 17 20 k=3(max diff) -> 
        // f f t f  f  f  f  f
        // f t t f  f  f  f  f
        // t t t f  f  f  f  f
        // t t t f  f  f  f  f
        // t t t f  t  f  f  f
        // t t t t  t  f  f  f
        // res = no(t) = 5

        Arrays.sort(nums);

        int res = 0;
        int curr = 1;

        for(int i = 1; i < n; i++){
            if(nums[i] - nums[i - 1] <= k)
                curr++;
            else{
                res = Math.max(res, curr);
                curr = 1;
            }
        }

        res = Math.max(res, curr);

        sb.append(n - res).append("\n");
    }
}