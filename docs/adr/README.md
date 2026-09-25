# Architecture Decision Records

Одно архитектурное решение — один файл: контекст, решение, рассмотренные альтернативы, последствия. ADR не переписывают: если решение изменилось, заводят новый ADR, а старому ставят статус `superseded by ADR-NNNN`. Шаблон — `template.md`.

Статусы: `proposed` — предложено, `accepted` — действует, `deprecated` — больше не актуально, `superseded` — заменено другим ADR. Статус `proposed` соответствует статусу НА СОГЛАСОВАНИИ в ТЗ, `accepted` — УТВЕРЖДЕНО.

| ADR | Решение | Статус | Дата |
|-----|---------|--------|------|
| [0001](0001-java-kotlin-split-by-module.md) | Разделение Java и Kotlin по модулям | accepted | 2026-09-23 |
| [0002](0002-monorepo-gradle-multiproject.md) | Монорепозиторий и многомодульная сборка Gradle | accepted | 2026-09-23 |
| [0003](0003-rabbitmq-with-outbox.md) | RabbitMQ с начала разработки, публикация через outbox | accepted | 2026-09-23 |
| [0004](0004-contracts-first.md) | Контракты до кода | accepted | 2026-09-23 |
| [0005](0005-owner-login-signed-link.md) | Вход владельца по одноразовой подписанной ссылке | accepted | 2026-09-23 |
| [0006](0006-mobile-app-kotlin.md) | Мобильное приложение на Kotlin параллельно с веб-дашбордом | accepted | 2026-09-23 |
