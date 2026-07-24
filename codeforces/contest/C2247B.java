import java.util.*;
import java.io.*;

public class C2247B {

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

    // will pass on codeforces
    static void solve() throws IOException {
        long n = nextLong();
        long k = nextLong();
        long m = nextLong();

        if(k > m){
            sb.append("NO\n");
            return;
        }

        sb.append("YES\n");
        if(k == 1){
            for(long i = 0; i < n; i++){
                sb.append(m).append(i == n - 1 ? "" : " ");
            }
        }else{
            long valk = m - k + 1;

            for(long i = 1; i <= n; i++){
                if(i % k == 0){
                    sb.append(valk);
                }else{
                    sb.append(1);
                }

                if(i < n)
                    sb.append(" ");
            }
        }
        sb.append("\n");
    }
}