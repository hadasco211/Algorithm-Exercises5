import java.util.*;

public class BoyerMooreSearcher {
    private final String pattern;
    private final int[] badCharTable;
    private final int[] goodSuffixTable;

    public BoyerMooreSearcher(String pattern) {
        this.pattern = pattern;
        this.badCharTable = buildBadCharTable(pattern);
        this.goodSuffixTable = buildGoodSuffixTable(pattern);
    }

    private int[] buildBadCharTable(String pattern) {
        final int ALPHABET_SIZE = 256;
        int[] table = new int[ALPHABET_SIZE];
        Arrays.fill(table, -1);
        for (int i = 0; i < pattern.length(); i++) {
            table[pattern.charAt(i)] = i;
        }
        return table;
    }

    private int[] buildGoodSuffixTable(String pattern) {
        int m = pattern.length();
        int[] table = new int[m];
        int[] suffixes = new int[m];

        Arrays.fill(table, m);
        suffixes[m - 1] = m;

        int g = m - 1;
        int f = 0;

        for (int i = m - 2; i >= 0; i--) {
            if (i > g && suffixes[i + m - 1 - f] < i - g) {
                suffixes[i] = suffixes[i + m - 1 - f];
            } else {
                g = Math.min(g, i);
                f = i;
                while (g >= 0 && pattern.charAt(g) == pattern.charAt(g + m - 1 - f)) {
                    g--;
                }
                suffixes[i] = f - g;
            }
        }

        for (int i = 0; i < m - 1; i++) {
            table[m - 1 - suffixes[i]] = m - 1 - i;
        }

        return table;
    }

 
}
