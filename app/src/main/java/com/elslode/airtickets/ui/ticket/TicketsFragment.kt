package com.elslode.airtickets.ui.ticket

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.elslode.airtickets.TicketApp
import com.elslode.airtickets.databinding.FragmentTicketsBinding
import com.elslode.airtickets.ui.ViewModelFactory
import com.elslode.airtickets.ui.adapter.TicketsAdapter
import javax.inject.Inject

class TicketsFragment : Fragment() {

    private var _binding: FragmentTicketsBinding? = null
    private val binding: FragmentTicketsBinding
        get() = _binding ?: throw RuntimeException("FragmentTicketsBinding is null")

    private val component by lazy { (requireActivity().application as TicketApp).component }
    private lateinit var mViewModel: TicketsViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTicketsBinding.inflate(inflater, container, false)
        mViewModel = ViewModelProvider(this, viewModelFactory)[TicketsViewModel::class.java]
        val adapter = TicketsAdapter()
        binding.rvTickets.adapter = adapter
        mViewModel.ticketsList.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
        return binding.root
    }
}