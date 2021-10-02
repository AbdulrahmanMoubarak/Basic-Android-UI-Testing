package com.training.espressouitestexample.ui.nav

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.training.espressouitestexample.R
import com.training.espressouitestexamples.ui.movie.MainActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MovieNavigationTest {

    private lateinit var activityScenario: ActivityScenario<MainActivity>

    @Before
    fun setup(){
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun test_movieDetailFragment_directorsFragment() {
        //nav to directors fragment
        onView(withId(R.id.movie_directiors)).perform(click())
        onView(withId(R.id.fragment_movie_directors)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment_movie_det)).check(matches(isDisplayed()))
    }

    @Test
    fun test_movieDetailFragment_starActorsFragment() {
        //nav to directors fragment
        onView(withId(R.id.movie_star_actors)).perform(click())
        onView(withId(R.id.fragment_movie_actors)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment_movie_det)).check(matches(isDisplayed()))
    }


}