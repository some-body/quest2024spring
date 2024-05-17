package com.yandex.mobius360quest

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.forEach
import androidx.navigation.fragment.findNavController
import com.yandex.mobius360quest.databinding.RotateLayoutBinding
import com.yandex.mobius360quest.to_hide.BaseViewBindingFragment
import com.yandex.mobius360quest.to_hide.Randomizer
import kotlin.random.Random
import kotlin.random.nextInt

class Rotate : BaseViewBindingFragment<RotateLayoutBinding>(RotateLayoutBinding::inflate) {

    private val value = Randomizer.getNewValue()
    private var entry = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        entry = binding.passcode.text.toString()
        makeCheck()
        binding.text.text = getString(R.string.rotate_passcode_template, value)
        binding.grid.forEach { view ->
            when {
                view.id == R.id.button_clear -> view.setOnClickListener {
                    binding.passcode.text = entry
                    entry = ""
                }
                view.id == R.id.button_next -> view.setOnClickListener {
                    findNavController().navigate(R.id.step_to_next)
                }
                view is Button -> view.setOnClickListener {
                    entry += view.text.toString()
                    binding.passcode.text = entry
                    makeCheck()
                }
            }
        }
    }

    private fun makeCheck() {
        binding.buttonNext.isEnabled = Randomizer.compare(entry, value)
    }
}