package com.elslode.airtickets.data.database

import androidx.room.Entity

data class AirTicketsInfoDbModel(
    val data: List<FlightInfoDbModel>,
    val result: String,
    val timestamp: Long
)