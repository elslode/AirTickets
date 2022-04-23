package com.elslode.airtickets.ui.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elslode.airtickets.data.repository.TicketAirRepositoryImpl
import com.elslode.airtickets.utils.SharedPrefManager
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val ticketAirRepositoryImpl: TicketAirRepositoryImpl,
    private val application: Application
) : ViewModel() {

    private val _errorLogin = MutableLiveData<Boolean>()
    val errorInputLogin: LiveData<Boolean>
        get() = _errorLogin

    private val _errorPassword = MutableLiveData<Boolean>()
    val errorInputPassword: LiveData<Boolean>
        get() = _errorPassword

    suspend fun getToken(login: String, password: String) {
        viewModelScope.launch {
            ticketAirRepositoryImpl.getToken(login, password)
            _errorLogin.value = ticketAirRepositoryImpl.stateLogin ?: false
            _errorPassword.value = ticketAirRepositoryImpl.statePassword ?: false
        }
    }

    fun getValueTokenSp(): String{
      return SharedPrefManager(application.applicationContext).getTokenSP().toString()
    }

}