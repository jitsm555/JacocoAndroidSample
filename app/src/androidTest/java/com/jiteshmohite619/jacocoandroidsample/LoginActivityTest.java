package com.jiteshmohite619.jacocoandroidsample;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.jiteshmohite619.jacocoandroidsample.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;


/**
 * Jacoco activity test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> rule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void shouldUpdateTextAfterButtonClick() {
        onView(ViewMatchers.withId(R.id.email)).perform(ViewActions.click()).perform
                (ViewActions.typeText("abc@gmail.com"));

        onView(ViewMatchers.withId(R.id.password)).perform(ViewActions.click()).perform
                (ViewActions.typeText("12345"));

        onView(ViewMatchers.withId(R.id.email_sign_in_button)).perform(ViewActions.click());
    }
}

