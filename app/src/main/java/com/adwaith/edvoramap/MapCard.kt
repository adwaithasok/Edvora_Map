package com.adwaith.edvoramap

import java.util.*

data class MapCard(
    val id: Int,
    val origin_station_code: String,
    val station_path: Array<Int>,
    val destination_station_code:Int,
    val date: String,
    val city: String,
    val state:String,
    val map_url: String,
)
