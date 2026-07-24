import java.util.*;
import java.io.*;

public class COddEvenIncrements {

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
        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }

        boolean isPossible = true;

        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                if(nums[i] % 2 != nums[0] % 2){
                    isPossible = false;
                    break;
                }
            }else{
                if(nums[i] % 2 != nums[1] % 2){
                    isPossible = false;
                    break;
                }
            }
        }

        if(isPossible){
            out.println("YES");
        }else{
            out.println("NO");
        }
    }
}