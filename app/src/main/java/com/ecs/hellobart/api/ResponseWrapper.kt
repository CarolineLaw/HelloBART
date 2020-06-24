package com.ecs.hellobart.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ResponseWrapper<T>(@Json(name = "root") val data: T) {

}