package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    @Test
    public void testEmptyString() {
        assertTrue(isBalanced(""));
    }

    @Test
    public void testOddLengthString() {
        assertFalse(isBalanced("()()("));
    }

    @Test
    public void testEvenLengthString() {
        assertTrue(isBalanced("()()"));
    }

    @Test
    public void testSingleSymbolType() {
        assertTrue(isBalanced("()[]{}"));
    }

    @Test
    public void testMixedSymbolType() {
        assertTrue(isBalanced("({[]})"));
        assertFalse(isBalanced("({[})"));
    }

    @Test
    public void testMixedSymbolAndOtherCharacters() {
        assertTrue(isBalanced("a(b[c]d)e{f}"));
        assertFalse(isBalanced("a(b[c]d}e{f}"));
    }

    @Test
    public void testNegateConditionalsMutant() {
        assertFalse(isBalanced("]"));
    }

    @Test
    public void testReplaceGreaterThanMutant() {
        assertFalse(isBalanced("{(])"));
    }

    @Test
    public void testRemoveConditionalMutant1() {
        assertFalse(isBalanced("("));
    }

    @Test
    public void testRemoveConditionalMutant2() {
        assertFalse(isBalanced("}"));
    }

    @Test
    public void testReplaceAssignmentWithIncrementMutant() {
        assertFalse(isBalanced("([)"));
    }
}