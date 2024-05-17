package com.yandex.mobius360quest.to_hide

import android.util.Base64
import java.nio.charset.Charset

// can not edit server code
// and can not see either
object AuthServer {
    private const val login = "bXJ5YW5kZXhvaWQzMjI=\n"
    private const val email = "bWVtQHlhLnJ1\n"
    private const val password1 = "MTIzNDU2Nzg5MA==\n"
    private const val password2 = "eW91IGFyZSBhd2Vzb21l\n"

    fun authorize(login: String, password: String): AuthResponse =
        if (checkLogin(login)) {
            checkPassword(password)
        } else {
            AuthResponse.WRONG
        }

    private fun checkLogin(login: String): Boolean {
        return encrypt(login) == this.login
    }

    private fun checkPassword(password: String): AuthResponse =
        when (encrypt(password)) {
            password1 -> AuthResponse.WEAK_PASS
            password2 -> AuthResponse.SUCCESS
            else -> AuthResponse.WRONG
        }

    fun checkEmail(email: String): Boolean {
        return encrypt(email) == this.email
    }

    private fun encrypt(string: String): String =
        Base64.encodeToString(string.toByteArray(Charset.defaultCharset()), Base64.DEFAULT)
}

enum class AuthResponse {
    SUCCESS,
    WRONG,
    WEAK_PASS
}