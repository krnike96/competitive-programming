import java.util.*;
import java.io.*;

public class BMarkTheDustSweeper {

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

        long sum = 0;
        int firstNonZeroIdx = -1;

        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
            if(firstNonZeroIdx == -1 && nums[i] > 0 && i < n - 1)
                firstNonZeroIdx = i;

            if(i < n - 1)
                sum += nums[i];
        }

        if(firstNonZeroIdx == -1){
            out.println(0);
            return;
        }

        int zeroCount = 0;
        for(int i = firstNonZeroIdx; i < n - 1; i++){
            if(nums[i] == 0)
                zeroCount++;
        }

        out.println(sum + zeroCount);
    }
}