import java.util.*;
import java.io.*;

public class Problem734A {

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
        int n = Integer.parseInt(nextLine().trim());
        String s = nextLine();

        int a = 0;
        int b = 0;

        for(char c : s.toCharArray()){
            if(c == 'A')
                a++;
            else 
                b++;
        }

        if(a > b)
            sb.append("Anton\n");
        else if(b > a)
            sb.append("Danik\n");
        else
            sb.append("Friendship\n");
    }
}