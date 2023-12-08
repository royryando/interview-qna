package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class BalancedBracketsTest {

    public boolean balancedBracket(String brackets) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < brackets.length(); i++) {
            char ch = brackets.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.add(ch);
            } else {
                switch (ch) {
                    case ')':
                        if (!stack.isEmpty() && stack.lastElement() == '(') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case '}':
                        if (!stack.isEmpty() && stack.lastElement() == '{') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case ']':
                        if (!stack.isEmpty() && stack.lastElement() == '[') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                }
            }
        }
        return stack.size() == 0;
    }

    @Test
    public void test() {
        Assertions.assertTrue(balancedBracket("[]{}([{}])"));
        Assertions.assertTrue(balancedBracket("(){[]}"));
        Assertions.assertTrue(balancedBracket("([]{}())"));
        Assertions.assertTrue(balancedBracket("{}()[]"));
        Assertions.assertTrue(balancedBracket("([])(){}(())()()"));
        Assertions.assertTrue(balancedBracket("(()agwg())((()agwga()())gawgwgag)"));
        Assertions.assertTrue(balancedBracket("(a)"));
        Assertions.assertTrue(balancedBracket("([])(){}(())()()"));

        Assertions.assertFalse(balancedBracket("[]([]{{])"));
        Assertions.assertFalse(balancedBracket("([)]"));
        Assertions.assertFalse(balancedBracket("{[{[]}}]"));
        Assertions.assertFalse(balancedBracket("({[}]())"));
        Assertions.assertFalse(balancedBracket("((()))]{}["));
        Assertions.assertFalse(balancedBracket("()()[{()})]"));
        Assertions.assertFalse(balancedBracket("(())))(("));
        Assertions.assertFalse(balancedBracket("{{[}]}"));
    }

}
