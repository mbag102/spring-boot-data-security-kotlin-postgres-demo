# spring-boot-kotlin-postgres-demo

To launch, cd into project's root directory and execute command : `gradle build && java -jar build/libs/spring-boot-kotlin-demo-0.0.1-SNAPSHOT.jar`

## Default configurations:

resources/application.yml

~~~~spring:
  jpa:
    database: POSTGRESQL
    show-sql: true
    hibernate:
      ddl-auto: create-drop
  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/kotlindemo
    user: mbagliojr <- You will want to change the user and, more likely than not, the url
    password: None by default
    
    
