package com.yandex.mobius360quest

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.yandex.mobius360quest.databinding.EmailFragmentBinding
import com.yandex.mobius360quest.to_hide.AuthServer
import com.yandex.mobius360quest.to_hide.BaseViewBindingFragment

class Mail : BaseViewBindingFragment<EmailFragmentBinding>(EmailFragmentBinding::inflate) {

//    private val emailChecker = RegexEmailChecker(regexProvider = { simpleEmailRegex })
//    private val simpleEmailRegex = Regex(".+@.+")
    // fix #4
    private val simpleEmailRegex = Regex(".+@.+")
    private val emailChecker = RegexEmailChecker(regexProvider = { simpleEmailRegex })
    // ------

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.resetPassword.setOnClickListener {
//            checkEmail(binding.inputEmail.toString())
            // fix #4
            checkEmail(binding.inputEmail.text.toString())
            // ------
        }
        binding.inputEmail.doOnTextChanged { _, _, _, _ ->
            binding.inputEmailLayout.error = null
        }
    }

    private fun checkEmail(email: String) {
        val ok = emailChecker.isEmail(email)

        if (ok && AuthServer.checkEmail(email)) {
            findNavController().navigate(R.id.step_to_next)
        } else {
            binding.inputEmailLayout.error = getString(
                if (ok) R.string.text_email_not_found else R.string.text_wrong_email
            )
        }
    }
}