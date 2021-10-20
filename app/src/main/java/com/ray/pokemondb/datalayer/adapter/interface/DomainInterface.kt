package com.ray.pokemondb.datalayer.adapter.`interface`

import com.ray.pokemondb.datalayer.cache.entity.common.BaseEntity

interface DomainInterface<T : BaseEntity , V : > {
    fun toDomain()
}