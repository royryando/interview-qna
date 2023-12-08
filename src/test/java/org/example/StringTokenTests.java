package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringTokenTests extends Assertions {

    public void main() {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String[] tokens = S.split("[^a-zA-Z]");
        int numTokens = 0;

        for (String token : tokens) {
            if (token.length() > 0) {
                numTokens++;
            }
        }

        System.out.println(numTokens);

        for (String token : tokens) {
            if (token.length() > 0) {
                System.out.println(token);
            }
        }
    }

    @Test
    public void test() {
        main();
    }

}
