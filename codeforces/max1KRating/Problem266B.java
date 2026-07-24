import java.util.*;
import java.io.*;

public class Problem266B {

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
        // int t = in.nextInt();
        // while (t-- > 0) 
            solve();
        out.flush();
        out.close();
    }

    static void solve() {
        int c = in.nextInt();
        int t = in.nextInt();

        char[] s = in.next().toCharArray();
        for(int i = 0; i < t; i++){
            for(int j = 0; j < s.length - 1; j++){
                if(s[j] == 'B' && s[j + 1] == 'G'){
                    swap(s, j, j + 1);
                    j++;
                }
            }
        }

        out.println(s);
    }

    private static void swap(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}