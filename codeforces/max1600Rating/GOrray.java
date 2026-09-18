import java.util.*;
import java.io.*;

public class GOrray {

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
        long[] a = nextLongArray(n);

        boolean[] used = new boolean[n];
        List<Long> res = new ArrayList<>();

        long curr = 0L;

        while(true){
            int bestIdx = -1;
            long bestOr = curr;

            for(int i = 0; i < n; i++){
                if(used[i]) continue;
                long newOr = curr | a[i];
                if(newOr > bestOr){
                    bestIdx = i;
                    bestOr = newOr;
                }
            }

            if(bestIdx == -1) break;
            used[bestIdx] = true;

            res.add(a[bestIdx]);
            curr |= a[bestIdx];
        }

        for(int i = 0; i < n; i++){
            if(!used[i]){
                res.add(a[i]);
            }
        }
        
        for(long x : res){
            sb.append(x).append(" ");
        }

        sb.append("\n");
    }
}