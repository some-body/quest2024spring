package com.yandex.mobius360quest.to_hide

import kotlin.random.Random
import kotlin.random.nextInt

// server class, do not edit
object Randomizer {

    fun getNewValue(): Int {
        var value = 0
        do {
            value = Random.Default.nextInt(1241212..998989912)
        } while(!value.toString().contains("0"))
        return value
    }

    fun compare(entry: String, value: Int): Boolean {
        return entry == value.toString()
    }
}