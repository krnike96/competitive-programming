import java.util.*;
import java.io.*;

public class BPasta {

    static StreamTokenizer in = new StreamTokenizer(new BufferedInputStream(System.in));
    static int nextInt() throws IOException { in.nextToken(); return (int) in.nval; }
    static long nextLong() throws IOException { in.nextToken(); return (long) in.nval; }
    static double nextDouble() throws IOException { in.nextToken(); return in.nval; }
    static String nextToken() throws IOException { in.nextToken(); return in.sval; }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String nextLine() throws IOException { return br.readLine(); }

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
        int m = nextInt();

        long[] noodles = new long[n];
        long[] days = new long[m];

        for(int i = 0; i < n; i++)
            noodles[i] = nextLong();
        
        for(int i = 0; i < m; i++)
            days[i] = nextLong();
        
        Arrays.sort(noodles);
        Arrays.sort(days);

        int i = 0;
        int j = 0;

        while(i < n && j < m){
            if(noodles[i] == days[j])
                j++;
            i++;
        }

        if(j == m)
            sb.append("Yes").append("\n");
        else
            sb.append("No").append("\n");
    }
}