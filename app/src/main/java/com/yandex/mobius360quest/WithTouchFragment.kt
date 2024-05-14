package com.yandex.mobius360quest

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.yandex.mobius360quest.databinding.FragmentWithTouchBinding
import com.yandex.mobius360quest.to_hide.BaseViewBindingFragment

class WithTouchFragment : BaseViewBindingFragment<FragmentWithTouchBinding>(FragmentWithTouchBinding::inflate) {

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.step_to_next)
        }
        binding.button.setOnTouchListener { _, _ ->
//            true
            false // Пример 4: наличие touch listener и true по возвращении (перехода не будет)
        }
    }
}