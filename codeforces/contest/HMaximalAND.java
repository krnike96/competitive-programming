import java.util.*;
import java.io.*;

public class HMaximalAND {

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
        long k = in.nextLong();

        int[] nums = new int[n];
        int[] bitCount = new int[31];

        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();

            for(int j = 0; j < 31; j++){
                if((nums[i] & (1 << j)) != 0)
                    bitCount[j]++;
            }
        }

        int res = 0;

        for(int i = 30; i >= 0; i--){
            int need = n - bitCount[i];

            if(k >= need){
                k -= need;
                res |= (1 << i);
            }else{
                if(bitCount[i] == n)
                    res |= (1 << i);
            }
        }

        out.println(res);
    }
}