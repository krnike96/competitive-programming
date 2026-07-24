import java.util.*;
import java.io.*;

public class C263ABeautifulMatrix {

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
        int r = -1;
        int c = -1;

        int[][] mat = new int[5][5];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                mat[i][j] = nextInt();
                if(r == -1 && mat[i][j] == 1){
                    r = i;
                    c = j;
                }
            }
        }

        int res = Math.abs(2 - r) + Math.abs(2 - c);

        sb.append(res).append("\n");
    }
}