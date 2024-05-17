package com.yandex.mobius360quest

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.google.android.material.slider.LabelFormatter
import com.yandex.mobius360quest.databinding.LockpuzzleBinding
import com.yandex.mobius360quest.to_hide.BaseViewBindingFragment

class Locked : BaseViewBindingFragment<LockpuzzleBinding>(LockpuzzleBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.post {
            binding.slider.values = listOf(binding.grid.x)
            binding.slider.valueFrom = binding.grid.x
            binding.slider.valueTo = binding.grid.width.toFloat()
        }
        binding.slider.labelBehavior = LabelFormatter.LABEL_GONE
        binding.slider.addOnChangeListener { _, value, fromUser ->
            binding.target.x = value * 10
            checkHit(false)
        }
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.step_to_next)
        }
    }

    fun checkHit(fromUser: Boolean) {
        val centerX = binding.target.x + binding.target.width / 2
        val centerY = binding.target.y + binding.target.height / 2
        val hitX = centerX in binding.placeholder.x..(binding.placeholder.y + binding.placeholder.width)
        val hitY = centerY in binding.placeholder.y..(binding.placeholder.y + binding.placeholder.height)
        binding.button.isEnabled = fromUser && hitX && hitY
    }
}
