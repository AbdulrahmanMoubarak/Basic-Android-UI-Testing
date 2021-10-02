package com.training.espressouitestexample.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.training.espressouitestexample.R
import com.training.espressouitestexamples.data.DummyMovies.THE_RUNDOWN
import com.training.espressouitestexamples.data.Movie
import com.training.espressouitestexamples.factory.MovieFragmentFactory
import com.training.espressouitestexamples.ui.movie.MovieDetailFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailFragmentTest{

    private var movie: Movie = THE_RUNDOWN
    private lateinit var fragmentFactory: MovieFragmentFactory
    private lateinit var bundle: Bundle
    private lateinit var scenario : FragmentScenario<MovieDetailFragment>

    @Before
    fun setup(){
        fragmentFactory = MovieFragmentFactory()
        bundle = Bundle()
        bundle.apply {
            putInt("movie_id", movie.id)
        }

        scenario = launchFragmentInContainer<MovieDetailFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )
    }

    @Test
    fun test_movieDataIsVisible() {
        onView(withId(R.id.movie_title)).check(matches(withText(movie.title)))
        onView(withId(R.id.movie_description)).check(matches(withText(movie.description)))
    }
}