package com.elslode.airtickets.data.mapper

import com.elslode.airtickets.data.database.FlightInfoDbModel
import com.elslode.airtickets.data.network.Model.FlightInfoDto
import com.elslode.airtickets.data.network.Model.TokenResponseDto
import com.elslode.airtickets.domain.FlightInfo
import com.elslode.airtickets.domain.TokenResponse
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapFlightTicketToTicket(flightInfo: FlightInfoDbModel) = FlightInfo(
        date = flightInfo.date,
        cost = flightInfo.cost,
        dest = flightInfo.dest,
        from = flightInfo.from
    )

    private fun mapFlyTicketInfoDtoToFlyTicketInfoDb(flightInfoDto: FlightInfoDto) = FlightInfoDbModel(
        cost = flightInfoDto.cost,
        from = flightInfoDto.from,
        dest = flightInfoDto.dest,
        date = flightInfoDto.date
    )

    fun mapListFlightTicketsDtoToTicketsDb(flightInfoDto: List<FlightInfoDto>) = flightInfoDto.map {
        mapFlyTicketInfoDtoToFlyTicketInfoDb(it)
    }


}