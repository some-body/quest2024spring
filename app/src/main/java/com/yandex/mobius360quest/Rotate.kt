package com.yandex.mobius360quest

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.forEach
import androidx.navigation.fragment.findNavController
import com.yandex.mobius360quest.databinding.RotateLayoutBinding
import com.yandex.mobius360quest.to_hide.BaseViewBindingFragment
import kotlin.random.Random
import kotlin.random.nextInt

class Rotate : BaseViewBindingFragment<RotateLayoutBinding>(RotateLayoutBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var value = 0
        do {
            value = Random.Default.nextInt(1241212..998989912)
        } while(!value.toString().contains("0"))
        binding.text.text = getString(R.string.rotate_passcode_template, value)
        binding.grid.forEach { view ->
            when {
                view.id == R.id.button_clear -> view.setOnClickListener { binding.passcode.text = "" }
                view.id == R.id.button_next -> view.setOnClickListener { findNavController().navigate(R.id.step_to_next) }
                view is Button -> view.setOnClickListener { binding.passcode.text = binding.passcode.text.toString() + view.text.toString() }
            }
        }
    }
}