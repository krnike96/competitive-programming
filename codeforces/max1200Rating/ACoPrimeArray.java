import java.util.*;
import java.io.*;

public class ACoPrimeArray {

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
        // int t = nextInt();
        // while (t-- > 0) 
            solve();
        
        System.out.print(sb);
        System.out.flush();
    }

    // should pass on CF
    static void solve() throws IOException {
        int n = nextInt();
        int[] nums = nextIntArray(n);
        boolean[] coPrimes = new boolean[n];
        int count = 0;

        for(int i = 0; i < n - 1; i++){
            if(gcd(nums[i], nums[i + 1]) != 1){
                coPrimes[i] = true;
                count++;
            }
        }

        sb.append(count).append("\n");
        for(int i = 0; i < n; i++){
            sb.append(nums[i]).append(" ");
            if(coPrimes[i])
                sb.append("1 ");
        }
        sb.append("\n");
    }

    static int gcd(int a, int b){
        while(b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}