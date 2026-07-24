import java.util.*;
import java.io.*;

public class GFalldown {

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
        int m = in.nextInt();

        char[][] mat = new char[n][m];

        for(int i = 0; i < n; i++){
            mat[i] = in.next().toCharArray();
        }

        for(int i = 0; i < m; i++){
            int availRow = n - 1;

            for(int j = n - 1; j >= 0; j--){
                if(mat[j][i] == 'o'){
                    availRow = j - 1;
                }else if(mat[j][i] == '*'){
                    mat[j][i] = '.';
                    mat[availRow][i] = '*';
                    availRow--;
                }
            }
        }

        for(int i = 0; i < n; i++){
            out.println(mat[i]);
        }
    }
}