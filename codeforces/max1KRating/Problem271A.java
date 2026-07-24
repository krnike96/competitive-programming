import java.util.*;
import java.io.*;

public class Problem271A {

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
        int y = in.nextInt();

        Set<Integer> set = new HashSet<>();

        for(int i = y + 1; i < 9999; i++){
            set.clear();

            int tmp = i;

            while(tmp > 0){
                set.add(tmp % 10);
                tmp /= 10;
            }

            if(set.size() == 4){
                out.println(i);
                break;
            }
        }
    }
}