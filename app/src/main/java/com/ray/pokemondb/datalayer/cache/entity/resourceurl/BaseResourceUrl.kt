package com.ray.pokemondb.datalayer.cache.entity.resourceurl

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.ray.pokemondb.datalayer.cache.entity.common.BaseEntity

data class BaseResourceUrl (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id: Long = 0,

    @ColumnInfo(name="name")
    var name: String = ""
): BaseEntity()