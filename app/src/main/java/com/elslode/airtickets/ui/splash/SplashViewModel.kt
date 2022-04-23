package com.elslode.airtickets.ui.splash

import androidx.lifecycle.ViewModel
import com.elslode.airtickets.data.repository.TicketAirRepositoryImpl
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val ticketAirRepositoryImpl: TicketAirRepositoryImpl
): ViewModel(){

    fun getValueTokenSp(): String? {
        return ticketAirRepositoryImpl.sharedPrefManager.getTokenSP()
    }
}