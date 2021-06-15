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

public class LoginTest {

    @Rule
    public ActivityTestRule<Login> acActivityTestRule=new ActivityTestRule<>(Login.class);
    Login login;
    String messageToDisplay;

    @Before
    public void setUp() throws Exception {
        login = acActivityTestRule.getActivity();
        messageToDisplay = "test";
    }

    @Test
    public void testUserInputScenario(){
        onView(withId(R.id.UsernameLogin)).perform(typeText(messageToDisplay));
        onView(withId(R.id.PasswordLogin)).perform(typeText(messageToDisplay));
        closeSoftKeyboard();
        onView(withId(R.id.ButtonLogin)).perform(click());
    }


    @After
    public void tearDown() throws Exception {
    }
}