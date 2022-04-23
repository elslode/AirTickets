package com.elslode.airtickets.domain

data class AirTicketsInfo (
    val data: List<FlightInfo>,
    val result: String,
    val timestamp: Long
)