package com.ray.pokemondb.datalayer.api.request.get.common

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.ray.pokemondb.datalayer.api.networkobject.common.ResponseObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BaseGetRequest<T> : Callback<T> {

    abstract var context: Context
    protected lateinit var callback: RequestCallback
    abstract val service : Call<T>

    abstract fun onResponseSuccess(callback: RequestCallback, response: Response<T>) : ResponseObject<T>?

    fun enqueue(callback: RequestCallback) {
        this.callback = callback
        service.enqueue(this)
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        callback.onFail()
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        val gson = Gson()
        Log.i("RESPONSE", gson.toJson(response.body()))
        val response: ResponseObject<T>? = onResponseSuccess(callback, response)
        callback.onSuccess(response)
    }

    interface RequestCallback {
        fun onSuccess(responseObject: ResponseObject<*>?)
        fun onFail()
    }

    companion object {
        val LIMIT: Int = 100
    }
}