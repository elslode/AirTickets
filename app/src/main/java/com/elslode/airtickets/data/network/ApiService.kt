package com.elslode.airtickets.data.network

import com.elslode.airtickets.data.network.Model.AirTicketsInfoDto
import com.elslode.airtickets.data.network.Model.TokenResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("auth")
    suspend fun getToken(
        @Query("login") login: String,
        @Query("password") password: String,
    ): TokenResponseDto

    @GET("get")
    suspend fun getTickets(
        @Query("token") token: String
    ): AirTicketsInfoDto
}