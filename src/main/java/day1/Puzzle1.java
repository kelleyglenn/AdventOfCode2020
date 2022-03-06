package day1;

import java.util.Arrays;

public class Puzzle1 {

    public static long productOfEntriesWithTotal(int[] entries, int total) {
        Arrays.sort(entries);
        int low = 0, high = entries.length - 1;
        while (low < high && entries[low] + entries[high] != total) {
            if (entries[low] + entries[high] < total) {
                low++;
            }
            else {
                high--;
            }
        }
        return (low < high) ? (long) entries[low] * (long) entries[high] : 0;
    }
}
