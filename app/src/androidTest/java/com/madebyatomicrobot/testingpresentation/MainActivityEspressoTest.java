package com.madebyatomicrobot.testingpresentation;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityEspressoTest() {
        ViewInteraction leftView = onView(
                allOf(withId(R.id.left), isDisplayed()));
        leftView.perform(replaceText("1"));

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.right), isDisplayed()));
        appCompatEditText2.perform(replaceText("2"));

        ViewInteraction textView = onView(
                allOf(withId(R.id.sum), withText("3"), isDisplayed()));
        textView.check(matches(withText("3")));
    }
}
