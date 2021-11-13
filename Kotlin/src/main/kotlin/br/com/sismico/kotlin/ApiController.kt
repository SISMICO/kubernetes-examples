package br.com.sismico.kotlin

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController(
    val calculator: Calculator
) {
    @PostMapping("/calculator")
    fun calculate(@RequestBody random: String): String {
        return calculator.calcular(random.toInt()).toString()
    }

    @GetMapping("/version")
    fun version(): String = "v1"
}