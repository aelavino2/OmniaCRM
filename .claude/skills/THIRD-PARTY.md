# Сторонние компоненты

## Скиллы Claude Code в `.claude/skills/`

Перечисленные ниже скиллы перенесены из проекта **ECC (Everything Claude Code)**
и распространяются на условиях лицензии MIT.

- Источник: https://github.com/affaan-m/ECC
- Версия, из которой взято: 2.2.2
- Коммит: `2b6e839771e53096d8451a213d40dc64ec8acac0`
- Дата переноса: 2026-09-22

Перенесённые скиллы:

`api-design`, `architecture-decision-records`, `backend-patterns`, `coding-standards`,
`contract-first`, `database-migrations`, `deployment-patterns`, `docker-patterns`,
`error-handling`, `git-workflow`, `hexagonal-architecture`, `java-coding-standards`,
`jpa-patterns`, `kotlin-coroutines-flows`, `kotlin-patterns`, `kotlin-testing`,
`postgres-patterns`, `springboot-patterns`, `springboot-security`, `springboot-tdd`,
`springboot-verification`, `tdd-workflow`

## Агенты Claude Code в `.claude/agents/`

Оттуда же и на тех же условиях:

`java-reviewer`, `kotlin-reviewer`, `database-reviewer`, `security-reviewer`,
`java-build-resolver`, `kotlin-build-resolver`

## Внесённые изменения

Часть файлов изменена относительно оригинала — примеры и команды сборки приведены
к Gradle в соответствии с §13 ТЗ, Maven-разделы удалены. Затронуты:

- `skills/springboot-verification`, `skills/springboot-tdd`, `skills/java-coding-standards`
- `agents/java-reviewer.md`, `agents/java-build-resolver.md`

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
