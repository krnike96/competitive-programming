import java.util.*;
import java.io.*;

public class ADoremySPaint3 {

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
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int a = nextInt();
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        if(map.size() == 1){
            sb.append("Yes\n");
            return;
        }else if(map.size() > 2){
            sb.append("No\n");
            return;
        }

        int[] a = new int[2];

        int idx = 0;

        for(int v : map.values()){
            a[idx++] = v;
        }

        if(Math.abs(a[0] - a[1]) <= 1)
            sb.append("Yes\n");
        else
            sb.append("No\n");
    }
}