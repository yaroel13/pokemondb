package com.ray.pokemondb.datalayer.api.services

import com.ray.pokemondb.datalayer.api.Retrofit
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon-species")
    fun getPokemonSpeciesResourceUrl(@Query("offset") offset: Int,
                                     @Query("limit") limit: Int)
            : Call<String>

    companion object {

        private var INSTANCE: PokemonApi = getInstance()

        fun getInstance() : PokemonApi {
            var instance = INSTANCE

            if(instance == null) {
                instance = Retrofit.getInstance().create(PokemonApi::class.java)
                INSTANCE = instance
            }

            return instance
        }

    }
}