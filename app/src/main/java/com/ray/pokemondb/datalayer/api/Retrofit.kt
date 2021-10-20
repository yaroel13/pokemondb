package com.ray.pokemondb.datalayer.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Retrofit {

    companion object {

        private val INSTANCE: Retrofit = getInstance()
        private val TIMEOUT: Long = 30

        fun getInstance(): Retrofit {
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    val httpClient = OkHttpClient.Builder()
                        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                        .callTimeout(TIMEOUT, TimeUnit.SECONDS)
                        .build()

                    instance = Retrofit.Builder()
                        .client(httpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("https://pokeapi.co/api/v2/")
                        .build()
                }

                return instance
            }
        }

    }

}