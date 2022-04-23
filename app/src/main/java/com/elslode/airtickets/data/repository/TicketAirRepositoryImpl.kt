package com.elslode.airtickets.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.elslode.airtickets.data.database.AirTicketsDao
import com.elslode.airtickets.data.mapper.Mapper
import com.elslode.airtickets.data.network.ApiService
import com.elslode.airtickets.domain.FlightInfo
import com.elslode.airtickets.domain.TicketAirRepository
import com.elslode.airtickets.utils.SharedPrefManager
import com.elslode.airtickets.utils.SharedPrefManager.Companion.PREFS_NAME
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TicketAirRepositoryImpl @Inject constructor(
    private val application: Application,
    private val apiService: ApiService,
    private val dao: AirTicketsDao,
    private val mapper: Mapper
) : TicketAirRepository {

    var stateLogin: Boolean? = null
    var statePassword: Boolean? = null

    val sharedPrefManager = SharedPrefManager(application.applicationContext)

    override suspend fun getToken(login: String, password: String) {

        val token = apiService.getToken(login, password)
        if (token.token?.isNotEmpty() == true) {
            with(sharedPrefManager) { saveToken(PREFS_NAME, token.token) }
        }

        if (token.result?.isNotEmpty() == true) when (token.result) {
            "invalid_login" -> stateLogin = true
            "invalid_password" -> statePassword = true
        }
    }

    override fun getTickets(): LiveData<List<FlightInfo>> {
        return Transformations.map(dao.getTicketList()) { ticket ->
            ticket.map {
                mapper.mapFlightTicketToTicket(it)
            }
        }
    }

    override suspend fun loadDataTickets() {
        val token = sharedPrefManager.getTokenSP()
        val tickets = token?.let { apiService.getTickets(it) }
        CoroutineScope(Dispatchers.IO).launch {
            tickets?.data?.let { mapper.mapListFlightTicketsDtoToTicketsDb(it) }?.let {
                dao.saveTicketsList(it)
            }
        }
    }
}