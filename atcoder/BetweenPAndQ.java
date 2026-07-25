import java.util.*;
import java.io.*;

public class BetweenPAndQ {

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
        // int t = nextInt();
        // while (t-- > 0) 
            solve();
        
        System.out.print(sb);
        System.out.flush();
    }

    static void solve() throws IOException {
        int n = nextInt();
        int[] p = nextIntArray(n);
        int[] q = nextIntArray(n);
        
        long[] fact = getFacts(n);
        
        long rankP = permute(p, n, fact);
        long rankQ = permute(q, n, fact);
        
        long res = rankQ - rankP - 1;
        
        if (res < 0) {
            res = 0;
        }
        
        sb.append(res).append("\n");
    }

    static long[] getFacts(int n) {
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        return fact;
    }

    static long permute(int[] perm, int n, long[] fact) {
        long rank = 1;
        boolean[] used = new boolean[n + 1];
        
        for (int i = 0; i < n; i++) {
            int curr = perm[i];
            int smaller = 0;
            
            for (int j = 1; j < curr; j++) {
                if (!used[j]) {
                    smaller++;
                }
            }
            
            rank += smaller * fact[n - 1 - i];
            used[curr] = true;
        }
        return rank;
    }
}