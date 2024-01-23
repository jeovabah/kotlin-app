package com.marketplace.android.utils

object Helper {
    fun applyCpfMask(cpf: String): String {
        return cpf.filter { it.isDigit() }
            .padEnd(11, ' ')
            .let {
                "${it.substring(0, 3)}.${it.substring(3, 6)}.${it.substring(6, 9)}-${it.substring(9, 11)}".trimEnd()
            }
    }

    fun applyDateMask(date: String): String {
        return date.filter { it.isDigit() }
            .padEnd(8, ' ')
            .let {
                "${it.substring(0, 2)}/${it.substring(2, 4)}/${it.substring(4, 8)}".trimEnd()
            }
    }

    fun applyPhoneMask(phone: String): String {
        return phone.filter { it.isDigit() }
            .padEnd(11, ' ')
            .let {
                "(${it.substring(0, 2)}) ${it.substring(2, 7)}-${it.substring(7, 11)}".trimEnd()
            }
    }
}
