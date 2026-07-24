import java.util.*;
import java.io.*;

public class C2247D {

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
        int q = nextInt();
        
        long[] packed = new long[n];
        for (int i = 0; i < n; i++) {
            long val = nextLong();
            packed[i] = (val << 20) | i;
        }
        
        Arrays.sort(packed);
        
        int maxXor = 0;
        for (int j = 0; j < n; j++) {
            int origIdx = (int) (packed[j] & 0xFFFFF);
            maxXor = Math.max(maxXor, origIdx ^ j);
        }
        
        sb.append(Integer.highestOneBit(maxXor)).append("\n");
    }
}