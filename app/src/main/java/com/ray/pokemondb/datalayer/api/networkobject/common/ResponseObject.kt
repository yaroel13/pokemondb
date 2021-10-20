package com.ray.pokemondb.datalayer.api.networkobject.common

data class ResponseObject<T>(
    var successObject: T
)