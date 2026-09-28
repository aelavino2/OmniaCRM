package com.omniacrm.payment

import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.testcontainers.postgresql.PostgreSQLContainer

@TestConfiguration(proxyBeanMethods = false)
class PostgresTestcontainer {
    @Bean
    @ServiceConnection
    fun postgres(): PostgreSQLContainer = PostgreSQLContainer("postgres:18.6")
}
