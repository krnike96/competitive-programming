import java.util.*;
import java.io.*;

public class AWayTooLongWords {

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
        
        if(sb.length() > 0)
            sb.setLength(sb.length() - 1);

        System.out.print(sb);
        System.out.flush();
    }

    static void solve() throws IOException {
        String s = nextToken();
        int n = s.length();
        if(s.length() <= 10){
            sb.append(s).append("\n");
            return;
        }

        sb.append(s.charAt(0));

        sb.append(String.valueOf(n - 2)).append(s.charAt(n - 1)).append("\n");
    }
}