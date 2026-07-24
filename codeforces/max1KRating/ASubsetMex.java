import java.util.*;
import java.io.*;

public class ASubsetMex {

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

        int[] freq = new int[101];

        for(int i = 0; i < n; i++){
            freq[in.nextInt()]++;
        }

        int i = 0;
        while(freq[i] >= 1)
            freq[i++]--;
        
        int mexA = i;

        i = 0;
        while(freq[i] >= 1)
            freq[i++]--;
        
        int mexB = i;

        out.println(mexA + mexB);
    }
}