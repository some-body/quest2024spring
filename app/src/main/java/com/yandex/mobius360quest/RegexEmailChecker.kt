package com.yandex.mobius360quest

class RegexEmailChecker(regexProvider: () -> Regex) {
    private val regex = regexProvider()

    fun isEmail(email: String): Boolean {
        return regex.matches(email)
    }
}