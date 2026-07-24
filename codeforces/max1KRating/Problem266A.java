import java.util.*;
import java.io.*;

public class Problem266A {

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
        int n = nextInt();
        String s = nextToken();

        if(s.length() == 1){
            sb.append("0\n");
            return;
        }

        int count = 0;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == s.charAt(i - 1))
                count++;
        }

        sb.append(count).append("\n");
    }
}