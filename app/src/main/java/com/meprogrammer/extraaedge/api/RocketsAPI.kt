package com.meprogrammer.extraaedge.api

import com.meprogrammer.extraaedge.models.rocketsList.RocketsListDatum
import retrofit2.Response
import retrofit2.http.*

interface RocketsAPI {

    @GET(".")
    suspend fun getRockets() : Response<List<RocketsListDatum>>

    @GET("{id}")
    suspend fun getRocketsDetail(@Path("id") id: String) : Response<RocketsListDatum>


}