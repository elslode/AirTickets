package com.elslode.airtickets.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.elslode.airtickets.R
import com.elslode.airtickets.TicketApp
import com.elslode.airtickets.databinding.SplashActivityBinding
import com.elslode.airtickets.ui.ViewModelFactory
import com.elslode.airtickets.ui.login.LoginFragment
import com.elslode.airtickets.ui.ticket.TicketsFragment
import javax.inject.Inject

class SplashActivity: AppCompatActivity() {

    private lateinit var mViewModel: SplashViewModel

    private val binding by lazy {
        SplashActivityBinding.inflate(layoutInflater)
    }

    private val component by lazy {
        (application as TicketApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this, viewModelFactory).get(SplashViewModel::class.java)

        if (!mViewModel.getValueTokenSp().isNullOrBlank()) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentHostFContainer, TicketsFragment())
                .commit()
        } else {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentHostFContainer, LoginFragment())
                .commit()
        }
    }
}