package com.training.espressouitestexample.ui.movie

import android.os.Bundle
import androidx.fragment.app.FragmentFactory
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
import com.training.espressouitestexamples.ui.movie.DirectorsFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DirectorsFragmentTest{

    private lateinit var directors : ArrayList<String>
    private lateinit var fragmentFactory: FragmentFactory
    private lateinit var bundle: Bundle
    private lateinit var scenario : FragmentScenario<DirectorsFragment>

    @Before
    fun setup(){
        directors = arrayListOf("R.J. Stewart", "James Vanderbilt")
        fragmentFactory = MovieFragmentFactory()
        bundle = Bundle()
        bundle.apply {
            putStringArrayList("args_directors", directors)
        }

        scenario = launchFragmentInContainer<DirectorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )
    }

    @Test
    fun test_isDirectorsListVisible(){
        val movie: Movie = THE_RUNDOWN
        onView(withId(R.id.directors_text)).check(matches(withText(
            DirectorsFragment.stringBuilderForDirectors(movie.directors!!)
        )))
    }
}