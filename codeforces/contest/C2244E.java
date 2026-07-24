import java.util.*;
import java.io.*;

public class C2244E {

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

        String s = nextLine();
        while(s == null || s.trim().isEmpty()){
            s = nextLine();
        }

        int[] prefix = new int[n];
        for(int i = 0; i < n - 1; i++){
            prefix[i + 1] = prefix[i];
            if(s.charAt(i) == s.charAt(i + 1)){
                prefix[i + 1]++;
            }
        }

        for(int i = 0; i < q; i++){
            int l = nextInt();
            int r = nextInt();
            int k = nextInt();

            l--;
            r--;

            int c = prefix[r] - prefix[l];
            int minOps = (c + 1) / 2;

            if(minOps <= k)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
    }
}