package com.yandex.mobius360quest

import android.os.Bundle
import android.view.View
import com.yandex.mobius360quest.databinding.FragmentFirstBinding
import com.yandex.mobius360quest.to_hide.BaseViewBindingFragment

class HelloFragment : BaseViewBindingFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {

    // fix #7
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonFirst.isContextClickable = true
    }
    // -------
}