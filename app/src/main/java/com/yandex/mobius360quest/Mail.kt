package com.yandex.mobius360quest

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.yandex.mobius360quest.databinding.EmailFragmentBinding
import com.yandex.mobius360quest.to_hide.BaseViewBindingFragment

class Mail : BaseViewBindingFragment<EmailFragmentBinding>(EmailFragmentBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.resetPassword.setOnClickListener {
            checkEmail(binding.inputEmail.text.toString())
        }
        binding.inputEmail.doOnTextChanged { _, _, _, _ ->
            binding.inputEmailLayout.error = null
        }
    }

    private fun checkEmail(email: String) {
        val ok = true // tut buded regex
        if (ok) {
            findNavController().navigate(R.id.step_to_next)
        } else {
            binding.inputEmailLayout.error = "check failed"
        }
    }
}