import java.util.*;
import java.io.*;

public class Problem112A {

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
        String a = nextLine().toLowerCase();
        String b = nextLine().toLowerCase();

        int res = 0;

        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) < b.charAt(i)){
                res = -1;
                break;
            }else if(a.charAt(i) > b.charAt(i)){
                res = 1;
                break;
            }
        }

        sb.append(res).append("\n");
    }
}