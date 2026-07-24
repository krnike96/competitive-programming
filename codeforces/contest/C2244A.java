import java.util.*;
import java.io.*;

public class C2244A {

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
        
        String s = nextLine();
        while (s == null || s.trim().isEmpty()) {
            s = nextLine();
        }
        
        int maxLen = 0;
        int currentLen = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '#') {
                currentLen++;
            } else {
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                }
                currentLen = 0;
            }
        }

        if (currentLen > maxLen) {
            maxLen = currentLen;
        }
        
        int ans = 0;
        if (maxLen > 0) {
            ans = (maxLen + 1) / 2;
        }
        
        sb.append(ans).append("\n");
    }
}