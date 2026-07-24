import java.util.*;
import java.io.*;

public class BC2ALucky {

    static BufferedReader stReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String firstLine = stReader.readLine();
        if (firstLine == null) return;

        int t = Integer.parseInt(firstLine.trim()); 
        
        while (t-- > 0) {
            solve();
        }

        System.out.print(sb);
        System.out.flush();
    }

    static void solve() throws IOException {
        String s = stReader.readLine();
        
        while (s != null && s.trim().isEmpty()) {
            s = stReader.readLine();
        }
        
        if (s == null) return;

        int s1 = 0;
        int s2 = 0;

        for(int i = 0; i < 3; i++){
            s1 += s.charAt(i) - '0';
            s2 += s.charAt(i + 3) - '0';
        }

        if(s1 == s2){
            sb.append("YES\n");
        }else{
            sb.append("NO\n");
        }
    }
}
