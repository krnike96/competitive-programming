import java.util.*;
import java.io.*;

public class CSpyingOnTheBeaver {

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

    // Should pass on CF
    static void solve() throws IOException {
        int n = nextInt();
        
        int[] parent = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            parent[i] = nextInt();
        }

        int m = nextInt();
        boolean[] isDam = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            isDam[nextInt()] = true;
        }

        @SuppressWarnings("unchecked")
        List<Integer>[] exposedChildren = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            exposedChildren[i] = new ArrayList<>();
        }

        List<Integer> cameraEdges = new ArrayList<>();

        for (int i = n; i >= 1; i--) {
            List<Integer> childrenWithExposed = exposedChildren[i];
            int totalExposedSources = childrenWithExposed.size() + (isDam[i] ? 1 : 0);

            if (totalExposedSources <= 1) {
                if (totalExposedSources == 1 && i > 1) {
                    exposedChildren[parent[i]].add(i);
                }
            } else {
                int camerasToPlace = totalExposedSources - 1;
                for (int j = 0; j < camerasToPlace; j++) {
                    cameraEdges.add(childrenWithExposed.get(j));
                }
                
                if (i > 1) {
                    exposedChildren[parent[i]].add(i);
                }
            }
        }

        sb.append(cameraEdges.size());
        for (int u : cameraEdges) {
            sb.append(' ').append(u);
        }
        sb.append('\n');
    }
}