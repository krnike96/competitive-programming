import java.util.*;
import java.io.*;

public class C101 {

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

    // passes on CF
    static void solve() throws IOException {
        int n = nextInt();
        int[] a = nextIntArray(n);

        List<Integer> ones = new ArrayList<>();
        List<Integer> negOnes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (a[i] == 1) {
                ones.add(i);
            } else if (a[i] == -1) {
                negOnes.add(i);
            }
        }

        if (ones.isEmpty()) {
            if (!negOnes.isEmpty()) {
                if (negOnes.size() == 1) {
                    a[negOnes.get(0)] = 1;
                } else {
                    a[negOnes.get(0)] = 1;
                    a[negOnes.get(negOnes.size() - 1)] = 1;
                    for (int i = 1; i < negOnes.size() - 1; i++) {
                        a[negOnes.get(i)] = 0;
                    }
                }
            }
        } else {
            int firstOne = ones.get(0);
            int lastOne = ones.get(ones.size() - 1);

            int firstNegBefore = -1;
            int lastNegAfter = -1;

            for (int idx : negOnes) {
                if (idx < firstOne) {
                    if (firstNegBefore == -1) {
                        firstNegBefore = idx;
                    }
                } else if (idx > lastOne) {
                    lastNegAfter = idx;
                }
            }

            for (int idx : negOnes) {
                if (idx == firstNegBefore || idx == lastNegAfter) {
                    a[idx] = 1;
                } else {
                    a[idx] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(a[i]).append(i == n - 1 ? "" : " ");
        }
        sb.append("\n");
    }
}