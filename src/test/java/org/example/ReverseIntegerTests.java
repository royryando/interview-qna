package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseIntegerTests extends Assertions {

    public Integer solve(Integer val) {
        String str = Integer.valueOf(Math.abs(val)).toString();
        StringBuilder res = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            res.append(str.charAt(i));
        }
        return Integer.parseInt(res.toString()) * (val < 0 ? -1 : 1);
    }

    public String reverse(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }

    public int reverse(int x) {
        String sign = "";
        if (x < 0) {
            sign = "-";
            x += -1;
        }

        String s = x + "";
        s = sign + reverse(s);

        int result;
        try {
            result = Integer.parseInt(s);
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    @Test
    public void testReverse() {
        assertEquals(solve(-123), -321);
        assertEquals(345, solve(543));
        assertEquals(2, solve(200));
        assertEquals(-2, solve(-200));

        /*assertEquals(-345, reverse(-543));
        assertEquals(reverse(-123), -321);
        assertEquals(reverse(543), 345);
        assertEquals(reverse(200), 2);
        assertEquals(reverse(-200), -2);*/
    }

}
