import java.util.*;
import java.io.*;

public class Problem236A {

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
        String s = nextLine();

        boolean[] freq = new boolean[26];
        for(char c : s.toCharArray()){
            freq[c - 'a'] = true;
        }

        int count = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i])
                count++;
        }

        if(count % 2 == 0){
            sb.append("CHAT WITH HER!\n");
        }else{
            sb.append("IGNORE HIM!\n");
        }
    }
}