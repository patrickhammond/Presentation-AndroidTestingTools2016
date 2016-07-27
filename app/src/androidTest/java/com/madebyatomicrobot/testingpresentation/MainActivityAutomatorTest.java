package com.madebyatomicrobot.testingpresentation;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.core.IsNull.notNullValue;

@SdkSuppress(minSdkVersion = 18)
public class MainActivityAutomatorTest {
    private static final String PACKAGE = "com.madebyatomicrobot.testingpresentation";
    private static final int LAUNCH_TIMEOUT = 5000;

    private UiDevice device;

    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        device.pressHome();

        // Wait for launcher
        final String launcherPackage = device.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE);
        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        device.wait(Until.hasObject(By.pkg(PACKAGE).depth(0)), LAUNCH_TIMEOUT);
    }

    @Test
    public void testCheckResults() throws Exception {
        UiObject leftView = device.findObject(new UiSelector().descriptionContains("Left"));
        UiObject rightView = device.findObject(new UiSelector().descriptionContains("Right"));
        UiObject sumView = device.findObject(new UiSelector().descriptionContains("Sum"));
        UiObject checkView = device.findObject(new UiSelector().descriptionContains("Check"));

        leftView.setText("1");
        rightView.setText("1");
        Assert.assertEquals("2", sumView.getText());

        checkView.click();

        // It would be nice to see that things are displayed, but don't make assumptions when
        // leaving one app and going to another that the other one will be what you've created
        // tests around (ex: a URL could open in Browser, Chrome, Firefox, Opera, etc).

        // Back to thumbs on screen testing...
    }
}
