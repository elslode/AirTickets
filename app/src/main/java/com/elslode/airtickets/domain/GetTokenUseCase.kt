package com.elslode.airtickets.domain

import javax.inject.Inject

class GetTokenUseCase @Inject constructor(
    private val repository: TicketAirRepository
) {
    suspend fun invoke(login: String, password: String) = repository.getToken(login, password)
}
