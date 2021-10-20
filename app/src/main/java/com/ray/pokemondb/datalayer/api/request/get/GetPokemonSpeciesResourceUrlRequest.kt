package com.ray.pokemondb.datalayer.api.request.get

import android.content.Context
import com.ray.pokemondb.datalayer.api.networkobject.common.ResponseObject
import com.ray.pokemondb.datalayer.api.request.get.common.BaseGetRequest
import com.ray.pokemondb.datalayer.api.request.get.common.BasePaginatedGetRequest
import retrofit2.Call
import retrofit2.Response

class GetPokemonSpeciesResourceUrlRequest(override var context: Context) : BasePaginatedGetRequest<BaseGetRequest<String>>() {

    override val service: Call<BaseGetRequest<String>>
        get() = TODO("Not yet implemented")

    override fun onResponseSuccess(
        callback: RequestCallback,
        response: Response<BaseGetRequest<String>>
    ): ResponseObject<BaseGetRequest<String>>? {
        TODO("Not yet implemented")
    }
}