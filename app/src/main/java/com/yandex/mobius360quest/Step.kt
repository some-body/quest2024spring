package com.yandex.mobius360quest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.yandex.mobius360quest.databinding.FragmentSecondBinding

class Step : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // fix #2
        binding.textviewSecond.isClickable = false
        // ---------
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.step_to_next)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}