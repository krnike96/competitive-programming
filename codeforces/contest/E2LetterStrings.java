import java.util.*;
import java.io.*;

public class E2LetterStrings {

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

        long[][] firstMatch = new long[12][12];
        long[][] secondMatch = new long[12][12];
        long[][] exactMatch = new long[12][12];

        long res = 0L;

        for(int i = 0; i < n; i++){
            String s = in.next();

            int u = s.charAt(0) - 'a';
            int v = s.charAt(1) - 'a';

            long common1st = 0L;
            long common2nd = 0L;

            for(int j = 0; j < 12; j++){
                common1st += firstMatch[u][j];
            }

            for(int j = 0; j < 12; j++){
                common2nd += secondMatch[j][v];
            }

            res += (common1st + common2nd - 2 * exactMatch[u][v]);

            firstMatch[u][v]++;
            secondMatch[u][v]++;
            exactMatch[u][v]++;
        }

        out.println(res);
    }
}