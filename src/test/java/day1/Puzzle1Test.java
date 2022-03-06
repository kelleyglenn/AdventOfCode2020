package day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

import org.junit.jupiter.api.Test;

class Puzzle1Test {

    @Test
    void productOfEntriesWithTotal() {
        // Edge cases
        assertEquals(0, Puzzle1.productOfEntriesWithTotal(new int[] {}, 10));
        assertEquals(0, Puzzle1.productOfEntriesWithTotal(new int[] { 10 }, 10));

        // Simple
        assertEquals(200, Puzzle1.productOfEntriesWithTotal(new int[] { 10, 20 }, 30));

        // Realistic
        assertEquals(200, Puzzle1.productOfEntriesWithTotal(
            new int[] { 1, 123, 546, 867, 345, 6457, 10, 435, 234, 6567, 3, 2, 12, 3, 345, 5, 54, 20, 64, 535, 3, 2 },
            30));

        // Given example
        assertEquals(514579, Puzzle1.productOfEntriesWithTotal(
            new int[] { 1721, 979, 366, 299, 675, 1456 },
            2020));
    }

    @Test
    void answerThePuzzle()
        throws IOException {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(Objects.requireNonNull(getClass().getResource("/day1/input.txt")).openStream()));
        ArrayList<Integer> entries = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            entries.add(Integer.parseInt(line));
        }

        assertEquals(866436, Puzzle1.productOfEntriesWithTotal(
            entries.stream().mapToInt(Integer::intValue).toArray(),
            2020));
    }
}