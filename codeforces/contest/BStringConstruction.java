import java.util.*;
import java.io.*;

public class BStringConstruction {

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
        int k = nextInt();

        if (k == 0) {
            for (int i = 0; i < n; i++) {
                sb.append(i % 2);
            }
            sb.append("\n");
            return;
        }

        int a = (k / 2) + 1;
        int b = ((k + 1) / 2) + 1;

        if (a + b > n) {
            sb.append("-1\n");
            return;
        }

        StringBuilder currStr = new StringBuilder();
        
        for (int i = 0; i < a; i++) 
            currStr.append('0');
        for (int i = 0; i < b; i++) 
            currStr.append('1');
        
        char nextChar = '0';
        for (int i = a + b; i < n; i++) {
            currStr.append(nextChar);
            nextChar = (nextChar == '0') ? '1' : '0';
        }

        int count0 = 0; 
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (currStr.charAt(i) == '0') count0++;
            else count1++;
        }

        if (Math.abs(count0 - count1) <= 1) {
            sb.append(currStr).append("\n");
        } else {
            sb.append("-1\n");
        }
    }
}