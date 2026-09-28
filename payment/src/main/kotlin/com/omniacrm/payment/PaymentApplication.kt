package com.omniacrm.payment

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class PaymentApplication

fun main(args: Array<String>) {
    SpringApplication.run(PaymentApplication::class.java, *args)
}
