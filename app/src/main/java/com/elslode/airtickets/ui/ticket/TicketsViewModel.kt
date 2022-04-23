package com.elslode.airtickets.ui.ticket

import androidx.lifecycle.ViewModel
import com.elslode.airtickets.domain.GetTicketsListUseCase
import com.elslode.airtickets.domain.LoadTicketsDataUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TicketsViewModel @Inject constructor(
    private val getTicketsListUseCase: GetTicketsListUseCase,
    private val loadTicketsDataUseCase: LoadTicketsDataUseCase
): ViewModel() {

    val ticketsList = getTicketsListUseCase()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            loadTicketsDataUseCase()
        }
    }
}