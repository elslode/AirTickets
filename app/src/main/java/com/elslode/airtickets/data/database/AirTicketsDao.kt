package com.elslode.airtickets.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AirTicketsDao {

    @Query("SELECT * FROM tickets ORDER BY cost DESC ")
    fun getTicketList(): LiveData<List<FlightInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTicketsList(tikets: List<FlightInfoDbModel>)
}