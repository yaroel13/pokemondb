package com.ray.pokemondb.datalayer.api.networkobject.common

import com.ray.pokemondb.datalayer.cache.entity.resourceurl.BaseResourceUrl

class BaseGetResourceUrlResponse<T : BaseResourceUrl> : BaseGetResponse<T>() {
    var count: Long? = null
    var next: String? = null
    var previous: String? = null
    var results: List<T>? = null
}