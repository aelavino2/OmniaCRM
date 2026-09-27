package com.omniacrm.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
@Import(PostgresTestcontainer.class)
class FlywayMigrationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void firstMigrationIsRecordedInHistory() {
        Boolean success = jdbcTemplate.queryForObject("select success from flyway_schema_history where version = '1'", Boolean.class);

        assertThat(success).isTrue();
    }
}
