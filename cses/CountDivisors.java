import java.util.*;
import java.io.*;

public class CountDivisors {

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
        precompute();
        while (t-- > 0) 
            solve();

        System.out.print(sb);
        System.out.flush();
    }

    static void solve() throws IOException {
        int n = nextInt();
        sb.append(divisors[n]).append("\n");
    }

    static int MAX = 1000000;
    static int[] divisors = new int[MAX + 1];
    static int[] spf = new int[MAX + 1];
    static int[] countSpf = new int[MAX + 1];
    static int[] primes = new int[80000];
    static int primeCount = 0;

    static void precompute(){
        divisors[1] = 1;

        for(int i = 2; i <= MAX; i++){
            if(spf[i] == 0){
                spf[i] = i;
                countSpf[i] = 1;
                divisors[i] = 2;
                primes[primeCount++] = i;
            }

            for(int j = 0; j < primeCount; j++){
                int p = primes[j];

                if(p > spf[i] || i * p > MAX)
                    break;

                int next = i * p;
                spf[next] = p;

                if(p == spf[i]){
                    countSpf[next] = countSpf[i] + 1;
                    divisors[next] = (divisors[i] / (countSpf[i] + 1)) * (countSpf[next] + 1); 
                }else{
                    countSpf[next] = 1;
                    divisors[next] = divisors[i] * 2;
                }
            }
        }
    }
}