#Docker plugin usage


**Build docker image**

`mvn clean install -DskipTests dockerfile:build`

**Run the image in a container**

`docker run -p 0.0.0.0:8081:8080 --name demoproducer -t --network producer-consumer yannisdw/demo `

**Test the running container**

`curl -I http://localhost:8081/hello`

`curl http://localhost:8081/hello`

**Test the running server (without container)**

`curl -I http://localhost:8080/hello`

`curl http://localhost:8080/hello`

**Use this service**
To connect to this container from another container, use the url "http://<name>:<port>/<endpoint>". 
The port is the one the server is running on inside the container.

The client container must be on the same network. 

e.g: `http://demoproducer:8080/hello` 

Source: https://spring.io/guides/gs/spring-boot-docker/
