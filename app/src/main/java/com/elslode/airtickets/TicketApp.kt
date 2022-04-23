package com.elslode.airtickets

import android.app.Application
import com.elslode.airtickets.di.DaggerApplicationComponent

class TicketApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

}