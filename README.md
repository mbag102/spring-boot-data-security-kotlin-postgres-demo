# spring-boot-data-security-kotlin-postgres-demo

To launch, cd into project's root directory and execute command : `gradle build && java -jar build/libs/spring-boot-kotlin-demo-0.0.1-SNAPSHOT.jar`

To launch in debug mode : `gradle build && java -Xdebug -Xrunjdwp:transport=dt_socket,address=8998,server=y -jar build/libs/spring-boot-kotlin-demo-0.0.1-SNAPSHOT.jar` <b>Note application will not boot until attached via debugger on port 8998.</b>

## Default Roles and Users
There are two users. <b>Username: admin, Password:admin</b> and <b>Username: user, Password: user</b>

Naturally, there are also two roles: <b>ROLE_USER and ROLE_ADMIN</b>

## Default configurations:

resources/application.yml

~~~~spring:
  jpa:
    database: POSTGRESQL
    show-sql: true
    hibernate:
      ddl-auto: create-drop <- If you don't wish to start with a fresh db on every application boot, you will want to change this to update or create
  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/kotlindemo
    user: mbagliojr <- You will want to change the user and, more likely than not, the url
    password: None by default
    
    
