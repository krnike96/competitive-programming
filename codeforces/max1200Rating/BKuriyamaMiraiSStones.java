import java.util.*;
import java.io.*;

public class BKuriyamaMiraiSStones {

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

    static void solve() throws IOException {
        int n = nextInt();
        long[] a = nextLongArray(n);
        int q = nextInt();
        
        long[] prefixA = new long[n + 1];
        for(int i = 0; i < n; i++){
            prefixA[i + 1] = a[i] + prefixA[i];
        }

        Arrays.sort(a);
        
        long[] prefixB = new long[n + 1];
        for(int i = 0; i < n; i++){
            prefixB[i + 1] = a[i] + prefixB[i];
        }

        for(int i = 0; i < q; i++){
            int t = nextInt();
            int l = nextInt();
            int r = nextInt();

            if(t == 1){
                sb.append(prefixA[r] - prefixA[l - 1]).append("\n");
            }else{
                sb.append(prefixB[r] - prefixB[l - 1]).append("\n");
            }
        }
    }
}