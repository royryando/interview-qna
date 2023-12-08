package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTests extends Assertions {

    /*

          O
       O     O
     O     O   O
   O   O
     */

    public static class Node {
        Node(int key) {
            this.key = key;
        }
        int key;
        Node right, left;
    }

    public int sum(Node root) {
        if (root == null) return 0;
        return root.key + sum(root.left) + sum(root.right);
    }

    @Test
    public void test() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        assertEquals(21, sum(root));
    }

}
