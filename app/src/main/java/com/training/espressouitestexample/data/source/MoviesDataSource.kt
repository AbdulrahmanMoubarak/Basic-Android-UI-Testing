package com.training.espressouitestexamples.data.source

import com.training.espressouitestexamples.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}