package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AnagramTests extends Assertions {

    static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        Arrays.sort(aChars);
        Arrays.sort(bChars);

        return Arrays.equals(aChars, bChars);
    }

    @Test
    public void test() {
        assertFalse(isAnagram("monkeys write", "New York Times"));
        assertTrue(isAnagram("monkeys write ", "new york times"));
        assertTrue(isAnagram("anagram", "margana"));
    }

}
