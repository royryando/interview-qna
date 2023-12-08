package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SumOfTwoNumbersTests extends Assertions {

    private boolean solve(int[] nums, int K) {
        Map<Integer, Boolean> numsMap = new HashMap<>();
        for (int num : nums) {
            if (numsMap.getOrDefault(K - num, false)) {
                return true;
            }
            numsMap.put(num, true);
        }
        return false;
    }

    /*
    Return array of the index
     */
    private int[] solve2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    @Test
    public void testSum() {
        //assertTrue(solve(new int[]{3, 1, 4, 2, 1}, 7));
        // 1, 3, 4
        // 1, 2, 1
        assertArrayEquals(new int[]{0, 1}, solve2(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{0, 3}, solve2(new int[]{2, 7, 11, 15}, 17));
        assertArrayEquals(new int[]{2, 3}, solve2(new int[]{2, 7, 11, 15}, 26));
    }

}
