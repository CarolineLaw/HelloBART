package com.ecs.hellobart.api

import com.squareup.moshi.*
import org.json.JSONObject

@JsonClass(generateAdapter = true)
data class StationsResponse(@Json(name = "stations") val listHolder: StationListHolder) {
    val stations get() = listHolder.stations
}

@JsonClass(generateAdapter = true)
data class StationListHolder(@Json(name = "station") val stations: List<Station>)

@JsonClass(generateAdapter = true)
data class Station(
    @Json(name = "name") val stationName: String,
    @Json(name = "abbr") val abbreviation: String,
    @Json(name = "address") val address: String,
    @Json(name = "city") val city: String
)