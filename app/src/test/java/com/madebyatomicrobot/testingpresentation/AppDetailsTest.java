package com.madebyatomicrobot.testingpresentation;


import android.content.Context;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

@RunWith(RobolectricTestRunner.class)
public class AppDetailsTest {
    @Test
    public void testAppNameIsCorrect() {
        Context context = RuntimeEnvironment.application;
        String appName = context.getString(R.string.app_name);
        Assert.assertEquals("Calculator", appName);
    }
}
