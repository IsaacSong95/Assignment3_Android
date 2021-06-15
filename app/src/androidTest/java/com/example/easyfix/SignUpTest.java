package com.example.easyfix;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class SignUpTest {
    @Rule
    public ActivityTestRule<SignUp> acActivityTestRule=new ActivityTestRule<>(SignUp.class);
    SignUp signUp;
    String messageToDisplay;

    @Before
    public void setUp() throws Exception {
        signUp = acActivityTestRule.getActivity();
        messageToDisplay = "test";
    }
    @Test
    public void testUserInputScenario(){
        onView(withId(R.id.fullname)).perform(typeText(messageToDisplay));
        onView(withId(R.id.email)).perform(typeText(messageToDisplay));
        onView(withId(R.id.username)).perform(typeText(messageToDisplay));
        onView(withId(R.id.password)).perform(typeText(messageToDisplay));
        closeSoftKeyboard();
        onView(withId(R.id.buttonSignup)).perform(click());
    }

    @After
    public void tearDown() throws Exception {
    }
}