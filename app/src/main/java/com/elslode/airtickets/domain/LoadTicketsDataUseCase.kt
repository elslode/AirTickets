package com.elslode.airtickets.domain

import javax.inject.Inject

class LoadTicketsDataUseCase @Inject constructor(
    private val repository: TicketAirRepository
) {
    suspend operator fun invoke() = repository.loadDataTickets()
}