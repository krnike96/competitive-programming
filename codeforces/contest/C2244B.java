import java.util.*;
import java.io.*;

public class C2244B {

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
        long sum = 0L;

        boolean possible = true;

        for(int i = 1; i <= n; i++){
            long a = nextLong();

            sum += a;

            long curr = (long) i * (i + 1) / 2;

            if(sum < curr)
                possible = false;
        }

        if(possible){
            sb.append("YES\n");
        }else{
            sb.append("NO\n");
        }
    }
}