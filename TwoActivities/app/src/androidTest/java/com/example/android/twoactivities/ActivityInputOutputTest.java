package com.example.android.twoactivities;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
/**
 * Instrumented test, which will execute on an Android device.
 * @RunWith: To create an instrumented JUnit 4 test class, add the @RunWith(AndroidJUnit4.class) annotation at the beginning of your test class definition.
 * @Rule: The @Rule annotation lets you add or redefine the behavior of each test method in a reusable way, using one of the test rule classes that the
 *        Android Testing Support Library provides, such as ActivityTestRule or ServiceTestRule. The rule above uses an ActivityTestRule object,
 *        which provides functional testing of a single Activity—in this case, MainActivity.class.
 *        During the duration of the test you will be able to manipulate your Activity directly, using ViewMatchers, ViewActions, and ViewAssertions.
 * @Test: The @Test annotation tells JUnit that the public void method to which it is attached can be run as a test case.
 *        A test method begins with the @Test annotation and contains the code to exercise and verify a single function in the component that you want to test.
 */


@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.android.twoactivities", appContext.getPackageName());
    }

//    @Test
//    public void activityLaunch() {
//        onView(withId(R.id.button_main)).perform(click());
//        onView(withId(R.id.text_header)).check(matches(isDisplayed()));
//        onView(withId(R.id.button_second)).perform(click());
//        onView(withId(R.id.text_header_reply)).check(matches(isDisplayed()));
//    }

    //https://developer.android.com/training/testing/ui-testing/espresso-testing#java
    @Test
    public void textInputOutput() {
        onView(withId(R.id.editText_main)).perform(typeText("This is a test."));
        onView(withId(R.id.button_main)).perform(click());
        onView(withId(R.id.text_message)).check(matches(withText("This is a test.")));
    }
}