package com.ecs.hellobart.api

import retrofit2.http.GET

interface BARTService {

    @GET("bsa.aspx/count?cmd=count")
    suspend fun getTrainCount(): ResponseWrapper<TrainCountResponse>

    @GET("stn.aspx/count?cmd=stns")
    suspend fun getStations(): ResponseWrapper<StationsResponse>
}