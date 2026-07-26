import java.util.*;
import java.io.*;

public class CWhereSTheBishop {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException { return Integer.parseInt(next()); }
    static long nextLong() throws IOException { return Long.parseLong(next()); }
    static double nextDouble() throws IOException { return Double.parseDouble(next()); }
    static char nextChar() throws IOException { return next().charAt(0); }

    static String nextLine() throws IOException {
        if (st != null && st.hasMoreTokens()) {
            StringBuilder rest = new StringBuilder(st.nextToken());
            while (st.hasMoreTokens()) rest.append(' ').append(st.nextToken());
            return rest.toString();
        }
        return br.readLine();
    }

    static int[] nextIntArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = nextInt();
        return arr;
    }

    static long[] nextLongArray(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = nextLong();
        return arr;
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) 
            solve();
        
        System.out.print(sb);
        System.out.flush();
    }

    static void solve() throws IOException {
        char[][] board = new char[8][8];

        for(int i = 0; i < 8; i++){
            String r = next();
            board[i] = r.toCharArray();
        }

        int r = -1;
        int c = -1;

        for(int i = 1; i < 7; i++){
            for(int j = 1; j < 7; j++){
                if(board[i][j] == '#'){
                    if(board[i - 1][j - 1] == '#' && board[i - 1][j + 1] == '#' 
                        && board[i + 1][j - 1] == '#' && board[i + 1][j + 1] == '#'
                    ){
                        r = i + 1;
                        c = j + 1;
                        break;
                    }
                }
            }

            if(r != -1)
                break;
        }

        sb.append(r).append(" ").append(c).append("\n");
    }
}