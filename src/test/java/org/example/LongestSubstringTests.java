package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringTests extends Assertions {

    public int solve(String s) {
        int res = 0;
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            System.out.println(temp);
            if (temp.contains(String.valueOf(s.charAt(i)))) {
                //df
                temp = "" + s.charAt(i);
            } else {
                temp += s.charAt(i-1);//d
            }
            res = Math.max(res, temp.length());
        }
        return res;
    }

    public int solve2(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0, end = 0, result = 0;
        for (end = 0; end < s.length(); end++){
            if (!map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), end);
            } else if(map.get(s.charAt(end)) < start) {
                map.replace(s.charAt(end), end);
            } else {
                result = Math.max(result, end - start);
                start = map.get(s.charAt(end)) + 1;
                map.replace(s.charAt(end), end);
            }
        }
        result = Math.max(result, end - start);
        return result;
    }

    @Test
    public void test() {
        /*assertEquals(3, solve("abcabcbb"));
        assertEquals(1, solve("bbbbb"));
        assertEquals(3, solve("pwwkew"));
        assertEquals(1, solve(" "));
        assertEquals(3, solve("dvdf"));*/

        /*assertEquals(3, solve2("abcabcbb"));
        assertEquals(1, solve2("bbbbb"));
        assertEquals(3, solve2("pwwkew"));
        assertEquals(1, solve2(" "));
        assertEquals(0, solve2(""));*/
        assertEquals(3, solve2("dvdf"));
    }

}
