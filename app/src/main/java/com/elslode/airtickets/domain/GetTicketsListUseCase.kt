package com.elslode.airtickets.domain

import javax.inject.Inject

class GetTicketsListUseCase @Inject constructor(
    private val repository: TicketAirRepository
) {
    operator fun invoke() = repository.getTickets()
}