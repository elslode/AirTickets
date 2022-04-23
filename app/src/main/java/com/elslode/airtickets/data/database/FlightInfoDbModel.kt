package com.elslode.airtickets.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tickets")
data class FlightInfoDbModel(
    @PrimaryKey
    val date: String,
    val cost: Int,
    val dest: String,
    val from: String
)