package com.madebyatomicrobot.testingpresentation;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainActivityTest {
    public @Rule ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testTitleShowsAppName() {
        CharSequence title = activityRule.getActivity().getTitle();
        assertEquals("Calculator", title);
    }
}