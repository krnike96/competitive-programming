import java.util.*;
import java.io.*;

public class Problem41A {

    static BufferedReader stReader = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in = new StreamTokenizer(stReader);
    static int nextInt() throws IOException { in.nextToken(); return (int) in.nval; }
    static long nextLong() throws IOException { in.nextToken(); return (long) in.nval; }
    static double nextDouble() throws IOException { in.nextToken(); return in.nval; }
    static String nextToken() throws IOException { in.nextToken(); return in.sval; }

    static String nextLine() throws IOException { return stReader.readLine(); }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // int t = nextInt(); 
        // while (t-- > 0) 
            solve();

        System.out.print(sb);
        System.out.flush();
    }

    static void solve() throws IOException {
        String s = nextToken();
        String t = nextToken();

        if(s.length() != t.length()){
            sb.append("NO\n");
            return;
        }

        String b = new StringBuilder(t).reverse().toString();

        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) != b.charAt(i)){
                sb.append("NO\n");
                return;
            }
        }

        sb.append("YES\n");
    }
}