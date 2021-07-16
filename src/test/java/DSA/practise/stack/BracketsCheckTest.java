package DSA.practise.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BracketsCheckTest {

    @Test
    void testPasses() {
        String[] testCases = {"[{}]", "(()())", "[]{}({})"};
        for (String testCase : testCases) {
            BracketsCheck bracketsCheck = new BracketsCheck(testCase);
            assertTrue(bracketsCheck.check());
        }

    }

    @Test
    void testFail() {
        String[] testCases = {"{]", "[()]))()"};
        for (String testCase : testCases) {
            BracketsCheck bracketsCheck = new BracketsCheck(testCase);
            assertFalse(bracketsCheck.check());
        }

    }
}