## Описание проекта

REST API для управления школьной базой данных склада с продуктами.

### Используемые технологии

- Java 21
- Sprint Boot 3
- Gradle
- Postgres

### Основные функции

- **CRUD-операции** для следующих сущностей:
- Brands
    - POST
      ![img.png](img.png)
    - GET all
      ![img_1.png](img_1.png)
- Products
    - POST
      ![img_2.png](img_2.png)
    - GET all
      ![img_3.png](img_3.png)
    - GET by id
      ![img_4.png](img_4.png)
      Run infrastructure, which includes database
      From root folder run:
```shell
cd infrastructure/scripts/
sh docker-compose-up.sh
```

Delete infrastructure
```shell
cd infrastructure/scripts/
sh docker-compose-down.sh
```
Run liquibase
```shell
cd service
./gradlew update
```