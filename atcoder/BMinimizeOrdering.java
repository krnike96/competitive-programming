import java.util.*;
import java.io.*;

public class BMinimizeOrdering {

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
        String s = nextLine();

        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] != 0){
                while(freq[i] > 0){
                    sb.append((char)(i + 'a'));
                    freq[i]--;
                }
            }
        }

        sb.append("\n");
    }
}