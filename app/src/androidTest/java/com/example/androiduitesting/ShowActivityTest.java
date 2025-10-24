package com.example.androiduitesting;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.anything;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShowActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> scenario =
            new ActivityScenarioRule<>(MainActivity.class);

    // Helper method to add a city
    private void addCity(String name) {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText(name));
        onView(withId(R.id.button_confirm)).perform(click());
    }

    @Test
    public void testActivitySwitch() {
        addCity("Bruh");
        onData(anything()).inAdapterView(withId(R.id.city_list)).atPosition(0).perform(click());
        onView(withId(R.id.text_city_name)).check(matches(isDisplayed()));
    }

    @Test
    public void testCityNameConsistency() {
        addCity("Stuff");
        onData(anything()).inAdapterView(withId(R.id.city_list)).atPosition(0).perform(click());
        onView(withId(R.id.text_city_name)).check(matches(withText("Stuff")));
    }

    @Test
    public void testBackButton() {
        addCity("ASDF");
        onData(anything()).inAdapterView(withId(R.id.city_list)).atPosition(0).perform(click());
        onView(withId(R.id.button_back)).perform(click());
        onView(withId(R.id.city_list)).check(matches(isDisplayed()));
    }
}
