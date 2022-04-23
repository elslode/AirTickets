package com.elslode.airtickets.data.network.Model

data class AirTicketsInfoDto (
    val data: List<FlightInfoDto>,
    val result: String,
    val timestamp: Long
)