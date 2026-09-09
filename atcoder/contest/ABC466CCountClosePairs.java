import java.util.*;
import java.io.*;

public class ABC466CCountClosePairs {

    static BufferedReader stReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        solve();
    }

    static void solve() throws IOException {
        String line = stReader.readLine();
        if (line == null) return;
        int n = Integer.parseInt(line.trim());

        long pairs = 0L;
        int left = 1;
        int right = 2;

        while (left <= n) {
            if (right > n) {
                pairs += (right - 1 - left);
                left++;
                continue;
            }

            System.out.println("? " + left + " " + right);
            System.out.flush();

            String res = stReader.readLine();
            if (res == null) break;
            res = res.trim();
            
            if (res.equals("Yes")) {
                right++;
            } else {
                pairs += (right - 1 - left);
                left++;
                if (right <= left) {
                    right = left + 1;
                }
            }
        }

        System.out.println("! " + pairs);
        System.out.flush();
    }
}
