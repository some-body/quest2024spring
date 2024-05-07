package com.yandex.mobius360quest

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.forEach
import com.yandex.mobius360quest.databinding.RotateLayoutBinding
import com.yandex.mobius360quest.to_hide.BaseViewBindingFragment

class Rotate : BaseViewBindingFragment<RotateLayoutBinding>(RotateLayoutBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.grid.forEach { view ->
            if (view is Button) {
                view.setOnClickListener {
                    binding.passcode.text = binding.passcode.text.toString() + view.text.toString()
                }
            }
        }
    }
}