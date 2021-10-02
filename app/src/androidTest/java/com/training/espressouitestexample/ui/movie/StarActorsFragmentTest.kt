package com.training.espressouitestexample.ui.movie

import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.training.espressouitestexample.R
import com.training.espressouitestexamples.data.DummyMovies
import com.training.espressouitestexamples.data.Movie
import com.training.espressouitestexamples.factory.MovieFragmentFactory
import com.training.espressouitestexamples.ui.movie.StarActorsFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class StarActorsFragmentTest{

    private lateinit var actors : ArrayList<String>
    private lateinit var fragmentFactory: FragmentFactory
    private lateinit var bundle: Bundle
    private lateinit var scenario : FragmentScenario<StarActorsFragment>

    @Before
    fun setup(){
        actors = arrayListOf("Dwayne Johnson", "Seann William Scott", "Rosario Dawson", "Christopher Walken")
        fragmentFactory = MovieFragmentFactory()
        bundle = Bundle()
        bundle.apply {
            putStringArrayList("args_actors", actors)
        }

        scenario = launchFragmentInContainer<StarActorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )
    }

    @Test
    fun test_isDirectorsListVisible(){
        val movie: Movie = DummyMovies.THE_RUNDOWN
        Espresso.onView(ViewMatchers.withId(R.id.star_actors_text)).check(
            ViewAssertions.matches(
                ViewMatchers.withText(
                    StarActorsFragment.stringBuilderForStarActors(movie.star_actors!!)
                )
            )
        )
    }
}