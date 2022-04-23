package com.elslode.airtickets.di

import android.app.Application
import com.elslode.airtickets.ui.login.LoginFragment
import com.elslode.airtickets.ui.splash.SplashActivity
import com.elslode.airtickets.ui.ticket.TicketsFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)

interface ApplicationComponent {

    fun inject(fragment: LoginFragment)
    fun inject(fragment: TicketsFragment)
    fun inject(splashActivity: SplashActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}