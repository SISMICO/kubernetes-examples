package br.com.sismico.kotlin

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.InetAddress

@RestController
class ApiController(
    val calculator: Calculator
) {
    @PostMapping("/calculator")
    fun calculate(@RequestBody random: String): CalculatorResponse {
        return CalculatorResponse(
            InetAddress.getLocalHost().hostName,
            calculator.calcular(random.toInt())
        )
    }

    @GetMapping("/version")
    fun version(): String = "v2"
}