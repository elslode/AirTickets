package com.elslode.airtickets.domain

data class FlightInfo(
    val cost: Int,
    val date: String,
    val dest: String,
    val from: String
)