import java.util.*;
import java.io.*;

public class Problem1509B {

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

    static void solve() throws IOException {
        int n = nextInt();
        char[] s = nextToken().toCharArray();
        
        List<Integer> tIndexes = new ArrayList<>();
        List<Integer> mIndexes = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(s[i] == 'M')
                mIndexes.add(i);
            else
                tIndexes.add(i);
        }

        if(2 * mIndexes.size() != tIndexes.size()){
            sb.append("NO\n");
            return;
        }

        int m = mIndexes.size();

        for(int i = 0; i < m; i++){
            if(tIndexes.get(i) > mIndexes.get(i)){
                sb.append("NO\n");
                return;
            }

            if(mIndexes.get(i) > tIndexes.get(i + m)){
                sb.append("NO\n");
                return;
            }
        }
        
        sb.append("YES\n");
    }
}