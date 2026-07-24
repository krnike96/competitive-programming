import java.util.*;
import java.io.*;

public class FEatingCandies {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) 
            solve();
        out.flush();
        out.close();
    }

    static void solve() {
        int n = in.nextInt();
        int[] weights = new int[n];

        for(int i = 0; i < n; i++){
            weights[i] = in.nextInt();
        }

        long aliceSum = 0L;
        long bobSum = 0L;
        long res = 0L;

        int lo = 0;
        int hi = n - 1;

        while(lo <= hi){
            if(aliceSum <= bobSum){
                aliceSum += weights[lo++];
            }else{
                bobSum += weights[hi--];
            }

            if(aliceSum == bobSum){
                res = lo + (n - 1 - hi);
            }
        }

        out.println(res);
    }
}