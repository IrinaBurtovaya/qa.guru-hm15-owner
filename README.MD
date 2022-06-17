**Команды запуска из терминала:**

для **WEB** тестов:
локальный запуск: gradle clean test -Denv=local  
удаленный запуск: gradle clean test -Denv=remote  

для **API** тестов:
gradle clean test --tests -DbaseURI= -Dtoken=

