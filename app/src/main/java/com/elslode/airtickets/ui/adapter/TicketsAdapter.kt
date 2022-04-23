package com.elslode.airtickets.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.elslode.airtickets.databinding.TicketItemInfoBinding
import com.elslode.airtickets.domain.FlightInfo

class TicketsAdapter(): ListAdapter<FlightInfo, TicketInfoViewHolder>(TicketInfoDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketInfoViewHolder {
        val binding = TicketItemInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TicketInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TicketInfoViewHolder, position: Int) {
        val ticket = getItem(position)
        with(holder.binding) {
            with(ticket) {
                tvCost.text = cost.toString()
                tvData.text = date
                tvDest.text = dest
                tvFrom.text = from
            }
        }
    }
}