package br.com.sismico.kotlin

import org.springframework.stereotype.Service
import java.util.*

@Service
class Calculator {
    fun calcular(random: Int): Double {
        var result = .0
        for (index in 0..random) {
            result += Random().nextDouble() * (index + random)
        }
        return result
    }
}