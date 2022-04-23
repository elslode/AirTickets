package com.elslode.airtickets.di

import android.app.Application
import com.elslode.airtickets.data.database.AirTicketsDao
import com.elslode.airtickets.data.database.AppDatabase
import com.elslode.airtickets.data.network.ApiFactory
import com.elslode.airtickets.data.network.ApiService
import com.elslode.airtickets.data.repository.TicketAirRepositoryImpl
import com.elslode.airtickets.domain.TicketAirRepository
import com.elslode.airtickets.utils.SharedPrefManager
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindsLoginRepository(impl: TicketAirRepositoryImpl): TicketAirRepository


    companion object {

        @Provides
        fun providesApiModule(): ApiService {
            return ApiFactory.apiService
        }

        @Provides
        fun providesTicketInfoDao(application: Application): AirTicketsDao {
            return AppDatabase.getInstance(application).airTicketsInfoDao()
        }

        @Provides
        fun providesSharedPrefManager(application: Application): SharedPrefManager {
            return SharedPrefManager(application.applicationContext)
        }
    }
}