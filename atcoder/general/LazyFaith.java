import java.util.*;
import java.io.*;

public class LazyFaith {

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
        long a = nextLong();
        long b = nextLong();
        long q = nextLong();

        long inf = 1_000_000_000_000L; 

        List<Long> shrines = new ArrayList<>();
        List<Long> temples = new ArrayList<>();

        for (int i = 0; i < a; i++) {
            shrines.add(nextLong());
        }
        for (int i = 0; i < b; i++) {
            temples.add(nextLong());
        }

        Collections.sort(shrines);
        Collections.sort(temples);

        shrines.add(0, -inf);
        shrines.add(inf);

        temples.add(0, -inf);
        temples.add(inf);

        for (int i = 0; i < q; i++) {
            long x = nextLong();

            int sIdx = lowerBound(shrines, x);
            long sr = shrines.get(sIdx);
            long sl = shrines.get(sIdx - 1);

            int tIdx = lowerBound(temples, x);
            long tr = temples.get(tIdx);
            long tl = temples.get(tIdx - 1);

            long minDistance = inf;

            long[] sChoices = {sl, sr};
            long[] tChoices = {tl, tr};

            for (long s : sChoices) {
                for (long t : tChoices) {
                    long firstShrine = Math.abs(x - s) + Math.abs(s - t);
                    long firstTemple = Math.abs(x - t) + Math.abs(t - s);
                    
                    long totalDist = Math.min(firstShrine, firstTemple);
                    minDistance = Math.min(minDistance, totalDist);
                }
            }

            sb.append(minDistance).append("\n");
        }
    }

    static int lowerBound(List<Long> list, long target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (list.get(mid) >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}