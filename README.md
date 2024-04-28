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