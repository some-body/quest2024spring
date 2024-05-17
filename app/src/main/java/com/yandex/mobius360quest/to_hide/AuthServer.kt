package com.yandex.mobius360quest.to_hide

import android.content.Context
import com.yandex.mobius360quest.R

// can not edit server code
// and can not see either
object AuthServer {

    fun authorize(context: Context, login: String, password: String): AuthResponse =
        if (checkLogin(context, login)) {
            checkPassword(context, password)
        } else {
            AuthResponse.WRONG
        }

    private fun checkLogin(context: Context, login: String): Boolean {
        return context.getString(R.string.log_cred_name) == login
    }

    private fun checkPassword(context: Context, password: String): AuthResponse =
        when (password) {
            context.getString(R.string.log_cred_pass) -> AuthResponse.WEAK_PASS
            "PAROLB" -> AuthResponse.SUCCESS
            else -> AuthResponse.WRONG
        }
}

enum class AuthResponse {
    SUCCESS,
    WRONG,
    WEAK_PASS
}