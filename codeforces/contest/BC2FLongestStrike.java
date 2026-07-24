import java.util.*;
import java.io.*;

public class BC2FLongestStrike {

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
        int k = nextInt();

        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = nextInt();
        }

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        int count = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1]){
                count++;
            }else{
                if(count >= k){
                    list.add(nums[i - 1]);
                }
                count = 1;
            }
        }

        if(count >= k)
            list.add(nums[n - 1]);

        if(list.isEmpty()){
            sb.append("-1\n");
            return;
        }

        int max = -1;
        int l = -1;
        int r = -1;

        int left = 0;
        for(int right = 0; right < list.size(); right++){
            if(right > 0 && list.get(right) != list.get(right - 1) + 1){
                left = right;
            }

            int currLen = right - left;
            if(currLen > max){
                max = currLen;
                l = list.get(left);
                r = list.get(right);
            }
        }

        sb.append(l).append(" ").append(r).append("\n");
    }
}