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
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class UserDetailsTest {
    @Rule
    public ActivityTestRule<UserDetails> acActivityTestRule=new ActivityTestRule<>(UserDetails.class);
    UserDetails UserDetails;
    String messageToDisplay;

    @Before
    public void setUp() throws Exception {
        UserDetails = acActivityTestRule.getActivity();
        messageToDisplay = "test";
    }

    @Test
    public void testUserInputScenario(){
        onView(withId(R.id.UpdateEmail)).perform(typeText(messageToDisplay));
        closeSoftKeyboard();
        onView(withId(R.id.ButtonUserUpdate)).perform(click());
    }

    @Test
    public void ButtonTest(){
        onView(withText("Delete")) .perform(click());

    }


    @After
    public void tearDown() throws Exception {
    }
}