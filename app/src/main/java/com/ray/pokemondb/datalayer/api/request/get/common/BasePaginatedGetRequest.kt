package com.ray.pokemondb.datalayer.api.request.get.common

abstract class BasePaginatedGetRequest<T> : BaseGetRequest<T>() {

    var offset: Int = 0

    fun downloadNext() {
        offset = offset + LIMIT
        enqueue(callback)
    }

}