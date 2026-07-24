import java.util.*;
import java.io.*;

public class ADivision {

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

        if(n >= 1900){
            out.println("Division 1");
        }else if(1600 <= n && n <= 1899){
            out.println("Division 2");
        }else if(1400 <= n && n <= 1599){
            out.println("Division 3");
        }else{
            out.println("Division 4");
        }
    }
}