package org.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testSolution() {
        Solution solution = new Solution();

        assertEquals(6, solution.solution(
                new String[]{
                        "...X..",
                        "....XX",
                        "..X..."
                }
        ));

        assertEquals(3, solution.solution(
                new String[]{
                        ".X.X..",
                        "....XX",
                        "..X..."
                }
        ));

        assertEquals(14, solution.solution(
                new String[]{
                        "......",
                        "......",
                        "......"
                }
        ));

        assertEquals(0, solution.solution(
                new String[]{""}
        ));
        assertEquals(0, solution.solution(
                new String[]{}
        ));
        assertEquals(0, solution.solution(
                new String[]{"X"}
        ));
    }

}