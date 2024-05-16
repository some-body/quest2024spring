package com.yandex.mobius360quest

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.yandex.mobius360quest.databinding.FragmentWithThreadBinding
import com.yandex.mobius360quest.to_hide.BaseViewBindingFragment

class WithThreadFragment : BaseViewBindingFragment<FragmentWithThreadBinding>(FragmentWithThreadBinding::inflate) {

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            Thread {
                requireActivity().runOnUiThread { // Пример 2: вызов не на UI thread (краш при клике)
                    findNavController().navigate(R.id.step_to_next)
                }
            }.start() // Пример 3: отсутствует вызов .start() у Thread (перехода не будет)
        }
    }
}