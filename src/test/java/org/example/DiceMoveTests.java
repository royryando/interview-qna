package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiceMoveTests extends Assertions {

    private int minimumStep(int N, int[] dices) {
        int minStep = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            int currentStep = 0;
            for (int j = 0; j < N; j++) {
                currentStep += getStepToChange(dices[j], i);
            }
            minStep = Math.min(minStep, currentStep);
        }
        return minStep;
    }

    private int getStepToChange(int a, int b) {
        int[] doubleSteps = new int[]{0, 6, 5, 4, 3, 2, 1};
        if (a == b) return 0;
        if (doubleSteps[a] == b) return 2;
        return 1;
    }

    @Test
    public void test() {
        assertEquals(1, minimumStep(3, new int[]{1, 4, 4}));
        assertEquals(0, minimumStep(3, new int[]{1, 1, 1}));
        assertEquals(2, minimumStep(3, new int[]{1, 3, 6}));
    }

}
