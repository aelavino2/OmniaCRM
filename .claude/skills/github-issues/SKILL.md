---
name: github-issues
description: Создание GitHub issues в репозитории OmniaCRM по шаблону проекта — на английском, разделы Context, Goal, Done when, Spec с кликабельными ссылками на ТЗ, sub-issues, связанная ветка, назначение разработчика по области (Java, Kotlin, React). Use when the user asks to create, draft or plan an issue, bug or task on GitHub for this repository.
metadata:
  origin: OmniaCRM
---

# Работа с GitHub issues в OmniaCRM

Моя задача в этом скилле одна: **создавать корректные issues** по принятому формату. Всё, что сверх этого, делаю только по явной просьбе пользователя.

Репозиторий: `aelavino2/OmniaCRM`. Шаблон: `.github/ISSUE_TEMPLATE/task.md`. ТЗ: `docs/terms-of-reference.md`.

## Чего я не делаю ни в коем случае

1. **Не меняю принятый формат и процесс.** Не правлю шаблон issue, структуру разделов, метки, правила именования веток, CLAUDE.md и этот скилл. Не изобретаю новые разделы и новые метки. Если считаю, что формат стоит улучшить, предлагаю это отдельным сообщением и жду решения.
2. **Не пушу без разрешения.** Никаких `git push`, `git commit`, создания веток на GitHub (включая `gh issue develop`), `gh pr create`, слияния PR без явного «да» пользователя в текущем разговоре. Разрешение на одно действие не распространяется на следующее.
3. **Не делаю других изменений в репозитории.** Не редактирую файлы, не закрываю, не правлю и не удаляю существующие issues и PR, не трогаю метки, milestones и настройки репозитория, если об этом прямо не попросили.
4. **Не создаю issues пачкой.** Одна задача за раз, вместе с её sub-issues. Сначала показываю черновик, создаю после согласия. Пользователь должен успевать за каждым шагом.
5. **Не выдумываю.** Не превращаю требование со статусом НА СОГЛАСОВАНИИ в решённое и не отвечаю на открытые вопросы (OQ) сам: если задача в них упирается, так и пишу в Context и ставлю ссылку на OQ. Не придумываю источники для Additional context: каждая ссылка должна быть реальной и проверенной.

## Порядок работы

1. **Прочитать ТЗ** по теме задачи в ветке `development` и найти одно-два главных требования. Если задача противоречит ТЗ, сказать об этом пользователю до черновика.
2. **Определить область** и исполнителя (таблица ниже).
3. **Написать черновик** issue и sub-issues по формату ниже и показать пользователю целиком: заголовок, текст, метку, исполнителя, список sub-issues, имя ветки.
4. **После согласия** создать issue, затем sub-issues и привязать их к родителю.
5. **Связанная ветка** создаётся на GitHub, это разновидность push. Поэтому в черновике отдельно спрашиваю: «создать связанную ветку `<N>-<name>`?» и создаю только при явном «да».
6. Показать пользователю ссылки на созданное.

## Формат issue

Всё на английском. Текст связный, списки нежелательны. Любой разработчик должен понять суть задачи из одного текста, ничего больше не открывая.

**Заголовок** — короткое повелительное предложение без префиксов: никаких `[Java]`, `[Kotlin]`, `[Решение]`, `[Контракт]`. Например: `Set up the Gradle build and the core module`.

```markdown
## Context

Why the task exists: the current state, what is wrong or missing, what depends on it.
Enough background that someone new to the project understands the problem.

## Goal

What to do and how the result should work. Concrete: modules, behaviour, constraints
from the spec that matter for this task.

## Done when

One paragraph describing the observable end state that proves the task is done
(what a developer runs or sees). Not a list.

## Additional context

Optional. Technical details that help to do the task: a proposed algorithm, library
or pattern, with links to sources (official docs, RFC, the original article) so the
reader can learn about it. Omit the section entirely if there is nothing real to add.

**Spec:** [REQ-15.7](https://github.com/aelavino2/OmniaCRM/blob/development/docs/terms-of-reference.md#req-15-7)
```

Разделов «Out of scope», «Invariants», чек-листов «Subtasks» нет. Мелкие шаги — отдельные sub-issues.

## Ссылки на ТЗ

В `Spec` одна-две ссылки, не больше. Каждая кликабельная и ведёт прямо на требование, чтобы не листать ТЗ.

| Что | Якорь | Пример |
|---|---|---|
| Требование REQ-X.Y | `#req-X-Y` | `…/terms-of-reference.md#req-5-1` |
| Открытый вопрос OQ-N | `#oq-N` | `…/terms-of-reference.md#oq-10` |
| Раздел без REQ (например 1.2) | автоякорь GitHub, кириллица URL-кодируется | `…#12-%D0%B8%D0%B4…` |

Правила:

- Ссылка всегда на ветку **`development`**: `https://github.com/aelavino2/OmniaCRM/blob/development/docs/terms-of-reference.md#…`. Ветки задач удаляются после слияния, и ссылка на них даёт 404.
- Текст ссылки — идентификатор (`REQ-15.7`), не номер раздела.
- Перед созданием issue проверяю, что якорь существует в `development`:

```bash
gh api -H "Accept: application/vnd.github.html" \
  "repos/aelavino2/OmniaCRM/contents/docs/terms-of-reference.md?ref=development" \
  | grep -c 'id="user-content-req-15-7"'
```

  `0` означает, что ссылка не работает. Тогда ссылку не ставлю, а сообщаю пользователю.

## Область и исполнитель

Область определяю по модулю (ADR-0001, `docs/adr/0001-java-kotlin-split-by-module.md`):

| Область | Модули | Метка | Исполнитель |
|---|---|---|---|
| Java | `core` | `java` | `aelavino2` |
| Kotlin | `payment`, `notification`, `telegram-bot`, `mobile-app` | `kotlin` | `skyyyylark` |
| React (фронтенд) | веб-дашборд владельца | `react` | `aelavino2` и `skyyyylark` |
| Всё остальное | `contracts`, инфраструктура, документация, решения команды | по смыслу из существующих (`documentation`, `architecture`, `decision`, `setup`) | один из двоих случайно |

Случайный выбор исполнителя:

```bash
AS=$( [ $((RANDOM % 2)) -eq 0 ] && echo aelavino2 || echo skyyyylark )
```

Одна задача — один модуль. Если задача задевает два модуля, предлагаю разбить её на две.

## Команды

Создать issue (тело — во временном файле в scratchpad):

```bash
gh issue create --repo aelavino2/OmniaCRM \
  --title "Set up the Gradle build and the core module" \
  --body-file <scratchpad>/issue.md \
  --label java --assignee aelavino2
```

Привязать sub-issue к родителю: нужен внутренний `id` дочернего issue, а не его номер.

```bash
CHILD_ID=$(gh api repos/aelavino2/OmniaCRM/issues/<child-number> --jq .id)
gh api -X POST repos/aelavino2/OmniaCRM/issues/<parent-number>/sub_issues -F sub_issue_id=$CHILD_ID
```

Связанная ветка, только после явного разрешения. Имя: `<номер issue>-<кратко-латиницей>`, база — `development`.

```bash
gh issue develop <number> --name "<number>-short-name" --base development
```

PR создаю только по просьбе, в `development`, и пишу в описании `Closes #<number>`.

## Автоматическое закрытие issues

Ограничение GitHub: issue закрывается сам (через `Closes #N` или привязку ветки) только когда PR слит в **ветку по умолчанию**. У нас это `main`, а PR идут в `development`. Поэтому после слияния PR в `development` issue остаётся открытым. Так уже было с #12 и #20.

Пока команда не решила, как это исправить, после слияния PR напоминаю пользователю, что связанный issue остался открытым, и закрываю его только с разрешения. Сам способ исправления (workflow GitHub Actions или смена ветки по умолчанию) — изменение репозитория, по пункту 3 без просьбы его не делаю.
