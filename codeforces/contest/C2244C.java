import java.util.*;
import java.io.*;

public class C2244C {

    static BufferedReader stReader = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in = new StreamTokenizer(stReader);
    static int nextInt() throws IOException { in.nextToken(); return (int) in.nval; }
    static long nextLong() throws IOException { in.nextToken(); return (long) in.nval; }
    static double nextDouble() throws IOException { in.nextToken(); return in.nval; }
    static String nextToken() throws IOException { in.nextToken(); return in.sval; }

    static String nextLine() throws IOException { return stReader.readLine(); }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = nextInt(); 
        while (t-- > 0) 
            solve();

        System.out.print(sb);
        System.out.flush();
    }

    static int find(int i, int[] parent) {
        int root = i;
        while (root != parent[root]) {
            root = parent[root];
        }
        int curr = i;
        while (curr != root) {
            int nxt = parent[curr];
            parent[curr] = root;
            curr = nxt;
        }
        return root;
    }

    static void solve() throws IOException {
        int n = nextInt();
        int x = nextInt();
        int y = nextInt();
        
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = nextInt();
        }
        
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int i = 1; i <= n; i++) {
            if (i + x <= n) {
                int rootI = find(i, parent);
                int rootNext = find(i + x, parent);
                if (rootI != rootNext) {
                    parent[rootI] = rootNext;
                }
            }
            if (i + y <= n) {
                int rootI = find(i, parent);
                int rootNext = find(i + y, parent);
                if (rootI != rootNext) {
                    parent[rootI] = rootNext;
                }
            }
        }
        
        boolean possible = true;
        for (int i = 1; i <= n; i++) {
            if (find(i, parent) != find(p[i], parent)) {
                possible = false;
                break;
            }
        }
        
        if (possible) {
            sb.append("YES\n");
        } else {
            sb.append("NO\n");
        }
    }
}