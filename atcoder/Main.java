import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] r = new int[m];
        int[] c = new int[m];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean[] rowSeen = new boolean[n + 1];
        boolean[] colSeen = new boolean[n + 1];
        
        int finalPiecesCount = 0;
        
        for (int i = m - 1; i >= 0; i--) {
            int currRow = r[i];
            int currCol = c[i];
            
            if (!rowSeen[currRow] && !colSeen[currCol]) {
                finalPiecesCount++;
            }
            
            rowSeen[currRow] = true;
            colSeen[currCol] = true;
        }
        
        System.out.println(finalPiecesCount);
    }
}
