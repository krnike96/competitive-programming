import java.util.*;
import java.io.*;

public class AFullHouse {

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
        int[] freq = new int[14];
        
        for(int i = 0; i < 5; i++){
            freq[nextInt()]++;
        }
        
        boolean hasTwo = false;
        boolean hasThree = false;

        for(int x : freq){
            if(x == 3)
                hasThree = true;
            if(x == 2) 
                hasTwo = true;
        }

        if(hasThree && hasTwo)
            sb.append("Yes\n");
        else 
            sb.append("No\n");
    }
}