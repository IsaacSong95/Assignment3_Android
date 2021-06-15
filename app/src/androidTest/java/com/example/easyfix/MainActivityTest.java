package com.example.easyfix;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> acActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = acActivityTestRule.getActivity();
    }

    @Test
    public void actionBarSignUpTest(){
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext());
        onView(withText("Signup")).perform(click());

    }
    @Test
    public void actionBarLoginTest(){
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext());
        onView(withText("Login")).perform(click());

    }

    @Test
    public void actionBarSettingsTest(){
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext());
        onView(withText("Settings")).perform(click());

    }


    @Test
    public void testFragment() {
        onView(withText("Basic maintenance")).perform(click());
    }

    @Test
    public void testFragment1() {
        onView(withText("Brakes")).perform(click());

    }

    @Test
    public void testFragment2() {
        onView(withText("Engines")).perform(click());

    }

    @Test
    public void testFragment3() {
        onView(withText("Batteries")).perform(click());

    }

    @Test
    public void testFragment4() {
        onView(withText("Tires")).perform(click());

    }

    @Test
    public void testFragment5() {
        onView(withText("Steering")).perform(click());

    }

//    @Test
//    public void testFragment6() {
//        onView(withText("Cooling")).perform(click());

//    }

//    @Test
//    public void testFragment7() {
//        onView(withText("Transmission")).perform(click());

//    }

    @Test
    public void clickButtonLocation() {
        onView(withId(R.id.nav_location)).perform(click()).check(matches(isDisplayed()));

    }

    @Test
    public void clickButtonSearch() {
        onView(withId(R.id.nav_search)).perform(click()).check(matches(isDisplayed()));

    }

    @Test
    public void clickButtonFavorite() {
        onView(withId(R.id.nav_favorite)).perform(click()).check(matches(isDisplayed()));

    }

    @After
    public void tearDown() throws Exception {
    }
}