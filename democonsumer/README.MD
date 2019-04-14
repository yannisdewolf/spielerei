#Docker plugin usage


**Build docker image**

`mvn clean install -DskipTests dockerfile:build`

**Run the image in a container**

`docker run -p 8080:8080 --name democonsumer -t -e SPRING_PROFILES_ACTIVE=container --network producer-consumer yannisdw/democonsumer `

**Test the running server**

`curl -I http://localhost:8080/consumeDemo`

`curl http://localhost:8080/consumeDemo`

Source: https://spring.io/guides/gs/spring-boot-docker/


