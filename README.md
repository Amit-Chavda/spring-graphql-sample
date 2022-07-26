# spring-graphql-sample
Sample Spring GraphQL App

## Dependency
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-graphql</artifactId>
    <version>2.7.2</version>
</dependency>
```

## application.yml
```
server:
  port: 9090
spring:
  #GrapgQL
  graphql:
    graphiql:
      enabled: true
      path: /graphiql

```

## QueryMapping
![1](https://user-images.githubusercontent.com/47694676/181023945-63429476-933f-485b-8a58-bfabc9dc9222.PNG)

## MutationMapping
![2](https://user-images.githubusercontent.com/47694676/181023963-a775b35e-366c-4877-a265-b4aa273724de.PNG)
