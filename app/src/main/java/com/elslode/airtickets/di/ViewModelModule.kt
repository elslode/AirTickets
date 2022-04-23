package com.elslode.airtickets.di

import androidx.lifecycle.ViewModel
import com.elslode.airtickets.ui.login.LoginViewModel
import com.elslode.airtickets.ui.splash.SplashViewModel
import com.elslode.airtickets.ui.ticket.TicketsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class )
    fun bindRegistrationViewModule(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class )
    fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TicketsViewModel::class )
    fun bindTicketsViewModel(viewModel: TicketsViewModel): ViewModel
}