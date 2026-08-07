import java.util.*;
import java.io.*;

public class BKalindromeArray {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException { return Integer.parseInt(next()); }
    static long nextLong() throws IOException { return Long.parseLong(next()); }
    static double nextDouble() throws IOException { return Double.parseDouble(next()); }
    static char nextChar() throws IOException { return next().charAt(0); }

    static String nextLine() throws IOException {
        if (st != null && st.hasMoreTokens()) {
            StringBuilder rest = new StringBuilder(st.nextToken());
            while (st.hasMoreTokens()) rest.append(' ').append(st.nextToken());
            return rest.toString();
        }
        return br.readLine();
    }

    static int[] nextIntArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = nextInt();
        return arr;
    }

    static long[] nextLongArray(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = nextLong();
        return arr;
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) 
            solve();
        
        System.out.print(sb);
        System.out.flush();
    }

    static void solve() throws IOException {
        int n = nextInt();
        int[] nums = nextIntArray(n);

        int l = 0;
        int r = n - 1;

        while(l < r){
            if(nums[l] != nums[r]){
                if(isPalin(nums, nums[l]) || isPalin(nums, nums[r]))
                    sb.append("YES\n");
                else
                    sb.append("NO\n");
                return;
            }
            l++;
            r--;
        }

        sb.append("YES\n");
    }

    static boolean isPalin(int[] nums, int x){
        int l = 0;
        int r = nums.length - 1;

        while(l < r){
            if(nums[l] == x)
                l++;
            else if(nums[r] == x)
                r--;
            else if(nums[l] != nums[r])
                return false;
            else{
                l++;
                r--;
            }
        }

        return true;
    }
}