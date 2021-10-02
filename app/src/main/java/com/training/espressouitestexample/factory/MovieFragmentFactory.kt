package com.training.espressouitestexamples.factory


import androidx.fragment.app.FragmentFactory
import com.training.espressouitestexamples.ui.movie.DirectorsFragment
import com.training.espressouitestexamples.ui.movie.MovieDetailFragment
import com.training.espressouitestexamples.ui.movie.StarActorsFragment

class MovieFragmentFactory : FragmentFactory(){

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when(className){

            MovieDetailFragment::class.java.name -> {
                MovieDetailFragment()
            }

            DirectorsFragment::class.java.name -> {
                DirectorsFragment()
            }

            StarActorsFragment::class.java.name -> {
                StarActorsFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }


}













