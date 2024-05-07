package com.yandex.mobius360quest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yandex.mobius360quest.databinding.OrdinaryDaysBinding

class AnotherOne : Fragment() {

    private var _binding: OrdinaryDaysBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        _binding = OrdinaryDaysBinding.inflate(inflater, container, true)
        _binding = OrdinaryDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.step_to_next)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}