import java.util.*;
import java.io.*;

public class ACreatingAbbreviations {

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
        int wordCount = nextInt();
        int abbrCount = nextInt();

        int availableLettersMask = 0;
        for (int i = 0; i < wordCount; i++) {
            String word = next();
            char initialChar = Character.toUpperCase(word.charAt(0));
            availableLettersMask |= (1 << (initialChar - 'A'));
        }

        int[] requiredMasks = new int[abbrCount];
        int[] leadingCharBit = new int[abbrCount];
        boolean[] isProcessed = new boolean[abbrCount];

        for (int i = 0; i < abbrCount; i++) {
            String abbreviation = next();
            leadingCharBit[i] = abbreviation.charAt(0) - 'A';
            int mask = 0;
            for (int j = 0; j < abbreviation.length(); j++) {
                mask |= (1 << (abbreviation.charAt(j) - 'A'));
            }
            requiredMasks[i] = mask;
        }

        int totalFormed = 0;
        boolean updated = true;

        while (updated) {
            updated = false;
            for (int i = 0; i < abbrCount; i++) {
                if (!isProcessed[i]) {
                    if ((requiredMasks[i] & availableLettersMask) == requiredMasks[i]) {
                        isProcessed[i] = true;
                        totalFormed++;
                        availableLettersMask |= (1 << leadingCharBit[i]);
                        updated = true;
                    }
                }
            }
        }

        if (totalFormed == abbrCount) {
            sb.append("YES\n");
        } else {
            sb.append("NO\n");
        }
    }
}