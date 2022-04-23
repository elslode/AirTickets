package com.elslode.airtickets.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.elslode.airtickets.domain.FlightInfo

object TicketInfoDiffCallback: DiffUtil.ItemCallback<FlightInfo>()  {

    override fun areItemsTheSame(oldItem: FlightInfo, newItem: FlightInfo): Boolean {
        return oldItem.from == newItem.from
    }

    override fun areContentsTheSame(oldItem: FlightInfo, newItem: FlightInfo): Boolean {
        return oldItem == newItem
    }
}