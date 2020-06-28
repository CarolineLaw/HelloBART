package com.ecs.hellobart.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class TrainCountResponse(@Json(name = "traincount") val trainCount: Int)