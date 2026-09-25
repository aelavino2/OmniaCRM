# Сторонние компоненты

## Скиллы Claude Code в `.claude/skills/`

Перечисленные ниже скиллы перенесены из проекта **ECC (Everything Claude Code)**
и распространяются на условиях лицензии MIT.

- Источник: https://github.com/affaan-m/ECC
- Версия, из которой взято: 2.2.2
- Коммит: `2b6e839771e53096d8451a213d40dc64ec8acac0`
- Дата переноса: 2026-09-22

Перенесённые скиллы (оставлены только подходящие стеку; `backend-patterns`, `coding-standards`,
`error-handling`, `kotlin-coroutines-flows`, `tdd-workflow` удалены 2026-09-23 как чужой стек или дубли):

`api-design`, `architecture-decision-records`,
`contract-first`, `database-migrations`, `deployment-patterns`, `docker-patterns`,
`git-workflow`, `hexagonal-architecture`, `java-coding-standards`,
`jpa-patterns`, `kotlin-patterns`, `kotlin-testing`,
`postgres-patterns`, `springboot-patterns`, `springboot-security`, `springboot-tdd`,
`springboot-verification`

## Агенты Claude Code в `.claude/agents/`

Оттуда же и на тех же условиях:

`java-reviewer`, `kotlin-reviewer`, `database-reviewer`, `security-reviewer`,
`java-build-resolver`, `kotlin-build-resolver`

## Внесённые изменения

Часть файлов изменена относительно оригинала:

- примеры и команды сборки приведены к Gradle (REQ-15.2), Maven-разделы удалены —
  `skills/springboot-verification`, `skills/springboot-tdd`, `skills/java-coding-standards`;
- жёсткий порог покрытия 80% снят, т.к. командой не утверждён — `skills/springboot-tdd`,
  `skills/springboot-verification`, `skills/kotlin-testing`;
- агенты адаптированы под Spring Boot + PostgreSQL + Gradle (убраны Quarkus, MongoDB, Maven,
  npm, Supabase RLS), добавлены инварианты раздела 5 ТЗ, снято «вызывать проактивно» —
  `agents/java-reviewer.md`, `agents/java-build-resolver.md`, `agents/database-reviewer.md`,
  `agents/security-reviewer.md`;
- `agents/kotlin-reviewer.md` переписан с Android/KMP/Compose на серверный Kotlin + Spring Boot
  (ADR-0001), добавлены инварианты ТЗ и правила разделения языков;
- ссылки на навыки, которых нет в проекте, убраны — `skills/contract-first`, `skills/postgres-patterns`.

В каждом изменённом файле стоит пометка о локальной правке сразу после frontmatter.

### Текст лицензии

MIT License

Copyright (c) 2026 Affaan Mustafa

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
