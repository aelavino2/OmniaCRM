package com.omniacrm.payment

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.jdbc.core.JdbcTemplate

@SpringBootTest
@Import(PostgresTestcontainer::class)
class FlywayMigrationTest {
    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    @Test
    fun `initial migration is recorded in payment schema`() {
        val success = jdbcTemplate.queryForObject(
            "select success from payment.flyway_schema_history where version = '1'",
            Boolean::class.javaObjectType,
        )

        assertThat(success).isTrue()
    }
}
