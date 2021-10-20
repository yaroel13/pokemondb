package com.ray.pokemondb.datalayer.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
    ],
    version = 1,
    exportSchema = false)
abstract class PokemonDb: RoomDatabase() {

    companion object{
        @Volatile
        private var INSTANCE: PokemonDb? = null
        private val DB_NAME: String = "pokemon_database.db"

        fun getInstance(context: Context): PokemonDb {
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PokemonDb::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }

}