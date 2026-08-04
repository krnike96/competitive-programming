import java.util.*;
import java.io.*;

public class C2MarenolHardVersion {

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
        char[] a = next().toCharArray();
        char[] b = next().toCharArray();

        int[] evenA = new int[n];
        int[] oddA = new int[n];
        int[] evenB = new int[n];
        int[] oddB = new int[n];

        int ptrEvenA = 0, ptrOddA = 0;
        int ptrEvenB = 0, ptrOddB = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == '1') {
                if (i % 2 == 0) evenA[ptrEvenA++] = i;
                else oddA[ptrOddA++] = i;
            }
            if (b[i] == '1') {
                if (i % 2 == 0) evenB[ptrEvenB++] = i;
                else oddB[ptrOddB++] = i;
            }
        }

        if (ptrEvenA != ptrEvenB || ptrOddA != ptrOddB) {
            sb.append("-1\n");
            return;
        }

        long minOps = 0;

        for (int i = 0; i < ptrEvenA; i++) {
            minOps += Math.abs(evenA[i] - evenB[i]) / 2;
        }

        for (int i = 0; i < ptrOddA; i++) {
            minOps += Math.abs(oddA[i] - oddB[i]) / 2;
        }

        sb.append(minOps).append("\n");
    }
}