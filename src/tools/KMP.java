package tools;

import java.util.Arrays;

public class KMP {
    private static int[] next;
    // KMP next
    private static int[] getNext(String pattern) {
        int j = 0, i = -1;
        next = new int[pattern.length() + 1];
        next[0] = -1;
        while (j < pattern.length()) {
            if (i == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++; j++;
                next[j] = i;
            } else {
                i = next[i];
            }
        }
        return next;
    }
    // KMP check
    private static int indexKMP(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (j == -1 || s.charAt(i) == t.charAt(j)) {
                i++; j++;
            } else {
                j = next[j];
            }
        }
        if (j == t.length()) {
            return i - t.length();
        } else {
            return -1;
        }
    }
}
