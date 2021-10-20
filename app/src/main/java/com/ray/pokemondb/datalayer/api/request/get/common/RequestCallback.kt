package com.ray.pokemondb.datalayer.api.request.get.common

import com.ray.pokemondb.datalayer.api.networkobject.common.ResponseObject

interface RequestCallback {
    fun onSuccess(responseObject: ResponseObject<*>?)
    fun onFail()
}