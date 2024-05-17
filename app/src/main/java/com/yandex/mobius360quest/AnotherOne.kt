package com.yandex.mobius360quest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
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
        // fix #5
        _binding = OrdinaryDaysBinding.inflate(inflater, container, false)
        // ------
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.button.setOnClickListener {
//            Thread {
//                binding.loader.isVisible = true
//                Thread.sleep(2000) // important background work !!!
//                binding.loader.isVisible = false
//                Handler(Looper.getMainLooper()) {
//                    findNavController().navigate(R.id.step_to_next)
//                    false
//                }.post{}
//            }.run()
//        }
        // fix #5
        binding.button.setOnClickListener {
            Thread {
                requireActivity().runOnUiThread {
                    binding.loader.isVisible = true
                }
                Thread.sleep(2000) // important background work !!!
                requireActivity().runOnUiThread {
                    binding.loader.isVisible = false
                }
                Handler(Looper.getMainLooper()) {
                    false
                }.post{
                    findNavController().navigate(R.id.step_to_next)
                }
            }.start()
        }
        // ------
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}