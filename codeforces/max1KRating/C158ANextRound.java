import java.util.*;
import java.io.*;

public class C158ANextRound {

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
        int k = nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = nextInt();

        int target = arr[k - 1];

        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > 0 && arr[i] >= target)
                count++;
        }

        sb.append(count).append("\n");
    }
}