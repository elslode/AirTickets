package com.elslode.airtickets.domain

import androidx.lifecycle.LiveData

interface TicketAirRepository {

    suspend fun getToken(login: String, password: String)

    fun getTickets(): LiveData<List<FlightInfo>>

    suspend fun loadDataTickets()
}