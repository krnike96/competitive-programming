import java.util.*;
import java.io.*;

public class Problem1714A {

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
        int sh = in.nextInt();
        int sm = in.nextInt();

        int total = sh * 60 + sm;
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int tmpH = in.nextInt();
            int tmpM = in.nextInt();

            int tmpTotal = tmpH * 60 + tmpM;

            int diff = tmpTotal - total;
            
            if(diff < 0){
                diff += (24 * 60);
            }

            minDiff = Math.min(minDiff, diff);
        }

        out.println(minDiff / 60 + " " + minDiff % 60);
    }
}