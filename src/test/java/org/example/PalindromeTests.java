package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeTests extends Assertions {

    public boolean isPalindrome(String text) {
        for (int i = 0; i < text.length()/2; i++) {
            if (text.charAt(i) != text.charAt(text.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testOne() {
        assertTrue(isPalindrome("kodok"));
        assertTrue(isPalindrome("koDok"));
        assertTrue(isPalindrome("kasur ini rusak"));
        assertTrue(isPalindrome("malam"));
        assertFalse(isPalindrome("Tamat"));
        assertFalse(isPalindrome("pohon"));
        assertFalse(isPalindrome("isI"));
    }

}
