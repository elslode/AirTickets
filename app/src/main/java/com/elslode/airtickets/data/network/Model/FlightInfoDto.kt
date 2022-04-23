package com.elslode.airtickets.data.network.Model

data class FlightInfoDto(
    val cost: Int,
    val date: String,
    val dest: String,
    val from: String
)