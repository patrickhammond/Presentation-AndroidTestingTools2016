package com.madebyatomicrobot.testingpresentation;

import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;

public class Calculator {
    /**
     * Given raw user input on both sides of a summation equation, return a formatted result.
     */
    public String add(String leftInput, String rightInput) {
        // Check for empty strings
        if (TextUtils.isEmpty(leftInput) || TextUtils.isEmpty(rightInput)) {
            return "";
        }

        // Try to parse integers out of what was input
        try {
            int left = Integer.parseInt(leftInput);
            int right = Integer.parseInt(rightInput);

            // Addition is *really* hard so we're going to let a calculator handle that for us
            int sum = new Calculator().add(left, right);

            return Integer.toString(sum);
        } catch (NumberFormatException ex) {
            return "";
        }
    }

    @VisibleForTesting
    int add(int left, int right) {
        return left + right;
    }
}
