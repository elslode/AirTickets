package com.elslode.airtickets.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.elslode.airtickets.R
import com.elslode.airtickets.TicketApp
import com.elslode.airtickets.databinding.FragmentRegistrationBinding
import com.elslode.airtickets.ui.ViewModelFactory
import com.elslode.airtickets.ui.ticket.TicketsFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class LoginFragment : Fragment() {

    private lateinit var mViewModel: LoginViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentRegistrationBinding? = null
    private val binding: FragmentRegistrationBinding
        get() = _binding ?: throw RuntimeException("FragmentRegistrationBinding is null")

    private val component by lazy {
        (requireActivity().application as TicketApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        mViewModel = ViewModelProvider(this, viewModelFactory)[LoginViewModel::class.java]
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val login = binding.etLogin.text
        val password = binding.etPassword.text

        mViewModel.errorInputLogin.observe(viewLifecycleOwner) {
            if (it) {
                binding.tilLogin.error = getString(R.string.error_login)
            } else {
                binding.tilLogin.error = null
            }
        }

        mViewModel.errorInputPassword.observe(viewLifecycleOwner) {
            if (it) {
                binding.tilPassword.error = getString(R.string.error_password)
            } else {
                binding.tilPassword.error = null
            }
        }

        binding.buttonLogin.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                mViewModel.getToken(
                    login = login.toString().trim(),
                    password = password.toString().trim()
                )
            }

            if (mViewModel.getValueTokenSp().isNotEmpty()) {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentHostFContainer, TicketsFragment())
                    .commit()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}